package com.example.flinkcdcclient;

import com.alibaba.ververica.cdc.connectors.mysql.MySQLSource;
import com.alibaba.ververica.cdc.debezium.StringDebeziumDeserializationSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class FlinkcdcClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlinkcdcClientApplication.class, args);
    }

}
