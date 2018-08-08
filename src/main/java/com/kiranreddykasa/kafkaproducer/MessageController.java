package com.kiranreddykasa.kafkaproducer;

import example.avro.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private KafkaTemplate<String, User> kafkaTemplate;

    public MessageController(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    public String message() {
        User user =new User();
        user.setFavoriteColor("blue");
        user.setFavoriteNumber(1234);
        user.setName("kiran");
        kafkaTemplate.send("messages", user);
        return "Success";
    }
}
