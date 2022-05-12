package com.mail.elmaalmi.billal.util;

import com.mail.elmaalmi.billal.model.Email;
import com.mail.elmaalmi.billal.config.AppConf;
import com.mail.elmaalmi.billal.model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    public void send(Email email, User user){
        Properties properties = new Properties();
        Session session;
        MimeMessage message;
        properties.put("mail.smtp.host", AppConf.MAIL_HOST);
        properties.put("mail.smtp.port","25");
        properties.put("mail.smtp.auth","true");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user.getEmail(),user.getPassword());
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
