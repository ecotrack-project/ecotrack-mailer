package com.urbemunda2.mailer.service;

import com.urbemunda2.mailer.to.MailTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(MailTO mailTO) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);


        helper.setTo(mailTO.getTo());
        helper.setSubject(mailTO.getSubject());
        helper.setText(mailTO.getBody());

        javaMailSender.send(message);

    }
}
