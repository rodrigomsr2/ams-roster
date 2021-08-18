package br.com.mesttra.roster.dto;

import lombok.Data;

@Data
public class SendMailDTO {

    private String to;
    private String subject;
    private String content;

}
