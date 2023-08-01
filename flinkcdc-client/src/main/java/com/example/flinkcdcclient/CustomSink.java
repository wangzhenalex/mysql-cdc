package com.example.flinkcdcclient;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.util.List;

public class CustomSink extends RichSinkFunction<String> {
    @Override
    public void invoke(String json, Context context) throws Exception {
        //OP字段：该字段也有4种取值，分别是C(create)、U(Update)、D(Delete)、Read®。
        //对于U操作，其数据部分同时包含了Before和After。
        System.out.println(">>>" + json);
    }

    @Override
    public void open(Configuration parameters) throws Exception {
    }

    @Override
    public void close() throws Exception {
    }
}