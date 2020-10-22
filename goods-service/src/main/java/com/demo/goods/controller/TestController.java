package com.demo.goods.controller;

import com.demo.Order;
import com.demo.goods.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Component
public class TestController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg){
        amqpTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME1,RabbitConfig.ROUTING_KEY,msg);
    }
}
