package com.example.flinkcdcclient;

import com.ververica.cdc.connectors.mysql.source.MySqlSource;
import com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.RestOptions;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class MySqlSourceExample {
    public static void main(String[] args) throws Exception {
        MySqlSource<String> source = MySqlSource.<String>builder()
                .hostname("localhost")
                .port(3306)
                .databaseList("test") // set captured database
                .tableList("test.xdual") // set captured table
                .username("root")
                .password("12345678")
                .deserializer(new JsonDebeziumDeserializationSchema()) // converts SourceRecord to JSON String
                .includeSchemaChanges(true)
                .fetchSize(100) // batch size when reading from database logs
                .build();
        // 启动⼀个webUI，指定本地WEB-UI端⼝号
        Configuration configuration = new Configuration();
        configuration.setInteger(RestOptions.PORT, 8081);
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment(configuration);
        //检查点间隔时间
        //checkpoint的侧重点是“容错”，即Flink作业意外失败并重启之后，能够直接从早先 打下的checkpoint恢复运⾏，且不影响作业逻辑的准确性。
        env.enableCheckpointing(5000);
        DataStreamSink<String> sink = env.fromSource(source, WatermarkStrategy.noWatermarks(), "MySQL Source")
                .addSink(new CustomSink());
        env.execute();
    }
}