# Flink CDC
[什么是 Flink CDC](https://github.com/ververica/flink-cdc-connectors)

## 概述
[Overview](https://ververica.github.io/flink-cdc-connectors/master/content/about.html) 

![Flink CDC](images/flink-cdc.png)

## 支持的连接器
![support-connector.png](images%2Fsupport-connector.png)

## 特性
- 支持读取数据库快照，即使发生故障也能继续读取事务日志，并进行一次性处理。
- DataStream API 的 CDC 连接器，用户可以在单个作业中使用多个数据库和表的更改，而无需部署 Debezium 和 Kafka。
- Table/SQL API 的 CDC 连接器，用户可以使用 SQL DDL 创建 CDC 源来监视单个表上的更改。
