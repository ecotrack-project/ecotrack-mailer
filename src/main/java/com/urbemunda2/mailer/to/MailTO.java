package com.urbemunda2.mailer.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailTO {

    private String to;
    private String subject;
    private String body;

}
