package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import sun.reflect.annotation.ExceptionProxy;

import java.util.Arrays;
import java.util.Properties;

public class KafkaBookConsumer1 {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "centos7_1:9092,centos7_2:9092,centos7_3:9092");
        props.put("group.id", "ykkim-consumer");
        props.put("enable.auto.commit", "true");
        props.put("auto.offset.reset", "latest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String>  consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("ykkim-topic"));

        try {
            while(true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Topic: %s, Parition: %s, Offset: %d, Key: %s, Value: %s\n"
                            , record.topic(), record.partition(), record.offset(), record.key(), record.value());
                }
            }
        } catch (Exception e) {
            e.toString();
        } finally {
            consumer.close();
        }
    }
}
