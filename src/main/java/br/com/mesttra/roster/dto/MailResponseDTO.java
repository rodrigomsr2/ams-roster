package br.com.mesttra.roster.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class MailResponseDTO {

    private Long id;
    private LocalDateTime timeSent;
    private String destination;
    private String content;

}
