package com.github.kanttanhed.mainapi.message;

import com.github.kanttanhed.mainapi.dto.CarPostRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KakfaProduceMessage {

    @Autowired
    private KafkaTemplate<String, CarPostRecord> kafkaTemplate;

    private  final String KAFKA_TOPIC = "car-post-topic";

    public void sendMessage(CarPostRecord carPostRecord){
        kafkaTemplate.send(KAFKA_TOPIC, carPostRecord);
    }
}
