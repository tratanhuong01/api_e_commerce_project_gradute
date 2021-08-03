package com.api.api_e_commerce_project_gradute.mail;

import com.api.api_e_commerce_project_gradute.DTO.DataSendMail;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {

  private JavaMailSender javaMailSender;

  public DataSendMail sendMail(DataSendMail dataSendMail) {
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setFrom("Dana-watch");
    simpleMailMessage.setTo(dataSendMail.getEmail());
    simpleMailMessage.setSubject(dataSendMail.getTopic());
    simpleMailMessage.setTo(dataSendMail.getBody());
    javaMailSender.send(simpleMailMessage);
    dataSendMail.setStatus("Success");
    return dataSendMail;
  }
}
