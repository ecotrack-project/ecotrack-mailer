package com.urbemunda2.mailer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.urbemunda2.mailer.service.MailService;
import com.urbemunda2.mailer.to.MailTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private MailService mailService;

    @JmsListener(destination = "mailerQueue") // la coda su cui è in ascolto
    public void receiveMessage(String jsonMessage) {

        try {
            MailTO mailTO = new ObjectMapper().readValue(jsonMessage, MailTO.class);

            System.out.println("Received message: " + mailTO);

            mailService.sendMail(
                    new MailTO(
                            mailTO.getTo(),
                            mailTO.getSubject(),
                            mailTO.getBody()
                    )
            );
        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
        }

    }
}
