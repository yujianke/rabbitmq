package com.jbf.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * Direct：定向，把消息交给符合指定routing key 的队列
 */
@Component
public class DirectListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "direct.queue1",durable = "true"),
            exchange = @Exchange(
                    value = "spring-direct-ex",
                    ignoreDeclarationExceptions = "true"
            ),
            key = "rongtingkey"
    ))
    public void listener01(String message){
        System.out.println("direct模式监听者01收到消息:"+message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "direct.queue2",durable = "true"),
            exchange = @Exchange(
                    value = "spring-direct-ex",
                    ignoreDeclarationExceptions = "true"
            ),
            key = "rongtingkey02"
    ))
    public void listener02(String message){
        System.out.println("direct模式监听者02收到消息:"+message);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "direct.queue3",durable = "true"),
            exchange = @Exchange(
                    value = "spring-direct-ex",
                    ignoreDeclarationExceptions = "true"
            ),
            key = "rongtingkey"
    ))
    public void listener03(String message){
        System.out.println("direct模式监听者03收到消息:"+message);
    }
}
