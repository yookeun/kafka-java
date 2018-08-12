## Kafka java client example

- 카프카 토픽 생성
```bash
./kafka/bin/kafka-topics.sh --zookeeper centos7_1:2181,centos7_2:2181,centos7_3:2181/ykkim-kafka --topic ykkim-topic --partitions 1 --replication-factor 3 --create
```

- 생성된 토픽 확인 
```bash
./kafka/bin/kafka-topics.sh --zookeeper centos7_1:2181,centos7_2:2181,centos7_3:2181/ykkim-kafka --topic ykkim-topic --describe
```

- 프로듀서로 실행
```bash 
./kafka/bin/kafka-console-producer.sh --broker-list centos7_1:9092,centos7_2:9092,centos7_3:9092 --topic ykkim-topic
```

- 컨슈머로 확인
```bash
./kafka/bin/kafka-console-consumer.sh --bootstrap-server centos7_1:9092,centos7_2:9092,centos7_3:9092 --topic ykkim-topic --from-beginning
```

--컨슈머 그룹확인
```bash
./kafka/bin/kafka-consumer-groups.sh --bootstrap-server centos7_1:9092,centos7_2:9092,centos7_3:9092 --list

```