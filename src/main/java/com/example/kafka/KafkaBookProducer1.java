package com.example.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaBookProducer1 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "centos7_1:9092,centos7_2:9092,centos7_3:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //StringDeserializer

        Producer<String, String> producer = new KafkaProducer<>(props);
        try {
            producer.send(new ProducerRecord<String,String>("ykkim-topic", "Apache Kafka3!"), new KafkaCallback());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
