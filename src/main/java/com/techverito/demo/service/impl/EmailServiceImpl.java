package com.techverito.demo.service.impl;

import com.techverito.demo.dto.MailBody;
import com.techverito.demo.service.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender javaMailSender;

    @Override
    public String sendEmail(MailBody mailBody) {

        return "Email Sent Successfully";

    }
}
