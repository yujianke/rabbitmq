package com.jbf.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqApplicationTest {

    @Autowired
    AmqpTemplate amqpTemplate;

    /**简单消息模型*/
    @Test
    public void simple() throws InterruptedException {
        String message ="simple message";
        for (int i = 0; i < 10; i++) {
        amqpTemplate.convertAndSend("spring-simple",message+i);
        }
    }

    /**work消息模型*/
    @Test
    public void work() throws InterruptedException {
        String message ="work message";
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("spring-work",message+i);
        }
    }
    /**订阅模型-Fanout*/
    @Test
    public void fanout() throws InterruptedException {
        String message ="fanout message";
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("spring-fanout-ex","",message+i);
        }
    }

    /**订阅模型-Direct*/
    @Test
    public void direct() throws InterruptedException {
        String message ="direct message";
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("spring-direct-ex","rongtingkey",message+i);
        }
    }

}