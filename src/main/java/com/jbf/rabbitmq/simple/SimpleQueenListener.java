package com.jbf.rabbitmq.simple;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleQueenListener {
    @RabbitListener(queuesToDeclare = @Queue("spring-simple"))
    public void listen(String message){
        System.out.println("接收到简单消息："+message);
    }
}
