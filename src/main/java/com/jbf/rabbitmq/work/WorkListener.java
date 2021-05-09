package com.jbf.rabbitmq.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkListener {
    @RabbitListener(queuesToDeclare = @Queue("spring-work"))
    public void listener(String message){
        System.out.println("work-listen01接收到消息:"+message);
    }
    @RabbitListener(queuesToDeclare = @Queue("spring-work"))
    public void listener2(String message){
        System.out.println("work-listen02接收到消息:"+message);
    }
}
