package com.jbf.rabbitmq.fanout;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * Fanout：广播，将消息交给所有绑定到交换机的队列，每个消费者都会收到同一条消息
 */
@Component
public class FanoutListener{
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout.queue1",durable = "true"),
            exchange = @Exchange(
                    value = "spring-fanout-ex",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listener01(String message){
        System.out.println("广播01接收到消息:"+message);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout.queue2",durable = "true"),
            exchange = @Exchange(
                    value = "spring-fanout-ex",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listener02(String message){
        System.out.println("广播02接收到消息:"+message);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout.queue3",durable = "true"),
            exchange = @Exchange(
                    value = "spring-fanout-ex",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listener03(String message){
        System.out.println("广播03接收到消息:"+message);
    }
}
