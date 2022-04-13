package com.mail.gl.mail_provider.util;

import com.mail.gl.mail_provider.model.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    public void send(Email email){
        Properties properties = new Properties();
        Session session;
        MimeMessage message;
        String SMTP_HOST = "192.168.1.103";
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port","25");
        properties.put("mail.smtp.auth","true");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("test1@fmail.com","1");
            }
        };
        session = Session.getDefaultInstance(properties,authenticator);
        try {
            InternetAddress[] recipients = new InternetAddress[1];
            recipients[0] = new InternetAddress("test2@fmail.com");
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress("test1@fmail.com"));
            message.addRecipients(Message.RecipientType.TO,recipients);
            message.setSubject("The first oo");
            message.setText("this is the first test email");
            Transport.send(message);
            System.out.println("Mail sent");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
