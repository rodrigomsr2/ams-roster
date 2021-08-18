package br.com.mesttra.roster.rest;

import br.com.mesttra.roster.dto.MailResponseDTO;
import br.com.mesttra.roster.dto.SendMailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "mailSender", url="http://localhost:8082/")
public interface MailSenderClient {

    @RequestMapping("/mails")
    MailResponseDTO sendMail(@RequestBody SendMailDTO sendMailDTO);

}
