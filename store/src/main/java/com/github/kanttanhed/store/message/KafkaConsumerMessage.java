package com.github.kanttanhed.store.message;

import com.github.kanttanhed.store.dto.CarPostRECORD;
import com.github.kanttanhed.store.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostRECORD carPost) {

        LOG.info("Received Car Post information: {}", carPost);
        carPostService.newPostDetails(carPost);

    }

}

