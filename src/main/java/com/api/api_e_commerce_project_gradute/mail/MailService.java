package com.api.api_e_commerce_project_gradute.mail;

import com.api.api_e_commerce_project_gradute.DTO.DataSendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  @Autowired
  private JavaMailSender javaMailSender;

  public DataSendMail sendMail(DataSendMail dataSendMail) {
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setFrom("Dana-watch");
    simpleMailMessage.setTo(dataSendMail.getEmail());
    simpleMailMessage.setSubject(dataSendMail.getTopic());
    simpleMailMessage.setText(dataSendMail.getBody());
    javaMailSender.send(simpleMailMessage);
    dataSendMail.setStatus("Success");
    return dataSendMail;
  }
}
