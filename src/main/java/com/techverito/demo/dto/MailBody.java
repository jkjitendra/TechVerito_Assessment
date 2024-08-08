package com.techverito.demo.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class MailBody {

    private String to;
    private String subject;
    private String text;
}
