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
        String SMTP_HOST = "192.168.43.29";
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port","25");
        properties.put("mail.smtp.auth","true");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getFrom(),"12345");
            }
        };
        session = Session.getDefaultInstance(properties,authenticator);
        try {
            InternetAddress[] recipients = new InternetAddress[1];
            recipients[0] = new InternetAddress(email.getTo());
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getFrom()));
            message.addRecipients(Message.RecipientType.TO,recipients);
            message.setSubject(email.getSubject());
            message.setText(email.getMessage());
            Transport.send(message);
            System.out.println("Mail sent");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
