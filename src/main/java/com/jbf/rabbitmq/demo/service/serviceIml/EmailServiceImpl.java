package com.jbf.rabbitmq.demo.service.serviceIml;

import com.alibaba.fastjson.JSONObject;
import com.jbf.rabbitmq.demo.Pojo.Email;
import com.jbf.rabbitmq.demo.service.IEmailService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmailServiceImpl implements IEmailService {
    /**
     *  注入RabbitTemplate
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    public void sendEmailUtil(List<Email> emails) {
        System.out.println("接收到消息。。。。。。。");
        System.out.println(emails);
    }

    @Override
    public void updateEmailStatus(List<Email> emails) {

    }

    @Override
    public void senEmail() {
        /**
         * 发送邮件信息到rabbit
         * param1：messageExchange  交换机名称
         * param2: topic.email 路由键
         * param3： JSONObject.toJSONString(emailList) 具体的消息
         */
        Email email = new Email();
        email.setName("111");
        email.setXxx("xxx");
        List<Email> emailList=new ArrayList();
        emailList.add(email);
        rabbitTemplate.convertAndSend("messageExchange", "topic.email", JSONObject.toJSONString(emailList));
    }





}
