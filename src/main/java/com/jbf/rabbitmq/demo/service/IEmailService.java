package com.jbf.rabbitmq.demo.service;

import com.jbf.rabbitmq.demo.Pojo.Email;

import java.util.List;

public interface IEmailService {
    public void sendEmailUtil(List<Email> emails);

    void updateEmailStatus(List<Email> emails);

    void senEmail();
}
