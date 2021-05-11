package com.jbf.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @DESCRIPTION： 消息队列配置
 **/
@Configuration
public class RabbitConfig {
    /**
     * 声明email队列
     */
    private static final String EMAIL_TOPIC = "q_topic_email";
    /**
     * 声明短信队列
     */
    private static final String SMS_TOPIC = "q_topic_sms";

    /**
     * @return 邮件队列
     */
    @Bean
    public Queue queueEmail() {
        return new Queue(EMAIL_TOPIC);
    }

    /**
     * @return 短信队列
     */
    @Bean
    public Queue queueSms() {
        return new Queue(SMS_TOPIC);
    }


    /**
     * @return 交换机
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("messageExchange");
    }

    /**
     * 将队列绑定到交换机，并设置该路由为topic.email
     *
     * @param queueEmail 邮件队列
     * @param exchange   交换机
     * @return 队列和交换机绑定
     */
    @Bean
    Binding bindingExchangeEmail(Queue queueEmail, TopicExchange exchange) {
        return BindingBuilder.bind(queueEmail).to(exchange).with("topic.email");
    }

    /**
     * 将队列绑定到交换机，并设置该路由为topic.sms
     *
     * @param queueSms 短信队列
     * @param exchange 交换机
     * @return 队列和交换机绑定
     */
    @Bean
    Binding bindingExchangeSms(Queue queueSms, TopicExchange exchange) {
        return BindingBuilder.bind(queueSms).to(exchange).with("topic.sms");
    }

}

