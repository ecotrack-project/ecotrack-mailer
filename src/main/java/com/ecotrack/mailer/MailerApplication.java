package com.ecotrack.mailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MailerApplication {

	public static void main(String[] args) {

		SpringApplication.run(MailerApplication.class, args);
		System.out.println("Mailer started...");

	}

}
