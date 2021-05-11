package com.jbf.rabbitmq.demo;

import com.alibaba.fastjson.JSONArray;
import com.jbf.rabbitmq.demo.Pojo.Email;
import com.jbf.rabbitmq.demo.service.IEmailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@RabbitListener(queues = "q_topic_email")
public class EmailListener {
    /**
     * emilService
     */
    @Resource
    private IEmailService emailService;


    /**
     * 消息监听类
     *
     * @param message 消息
     */
    @RabbitHandler
    public void process(String message) {
        handler(message);
    }

    /**
     * rabbit监听到信息，异步发送
     *
     * @param message 消息
     */
    private void handler(String message) {
        List<Email> emails = JSONArray.parseArray(message, Email.class);
        if (emails.size() > 0) {
            emailService.sendEmailUtil(emails);
            emailService.updateEmailStatus(emails);
        }
    }
}

