package com.example.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KafkaCallback implements Callback {
    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if (metadata != null) {
            System.out.println("Partition: " + metadata.partition() +", offset :" + metadata.offset());
        } else {
            exception.printStackTrace();
        }
    }
}
