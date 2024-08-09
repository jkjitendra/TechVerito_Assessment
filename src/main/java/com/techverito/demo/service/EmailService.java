package com.techverito.demo.service;

import com.techverito.demo.dto.MailBody;

public interface EmailService {

    public String sendEmail(MailBody mailBody);
}
