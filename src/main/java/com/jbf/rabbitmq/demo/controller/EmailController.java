package com.jbf.rabbitmq.demo.controller;

import com.jbf.rabbitmq.demo.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class EmailController {
  @Autowired
    IEmailService emailService;
    @GetMapping("/emal")
    public void sendMessage(){
        emailService.senEmail();
    }
}
