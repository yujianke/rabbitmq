package com.jbf.rabbitmq.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "topic.queue1",durable = "true"),
            exchange = @Exchange(
                    value = "spring-topic-ex",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"lxr.*"}
    ))
    public void listener01(String msg) {
        System.out.println("TopicListener01 接收到消息：" + msg);
    }



    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "topic.queue2",durable = "true"),
            exchange = @Exchange(
                    value = "spring-topic-ex",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"yjk.*"}
    ))
    public void listener02(String msg) {
        System.out.println("TopicListener02 接收到消息：" + msg);
    }
}
