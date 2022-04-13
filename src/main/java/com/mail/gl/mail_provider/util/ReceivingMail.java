package com.mail.gl.mail_provider.util;

import com.mail.gl.mail_provider.model.Email;
import com.sun.mail.pop3.POP3Folder;

import javax.mail.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReceivingMail {
    public List<Email>  receiving()  {
        List<Email> emails = new ArrayList<>();
        try {
            Properties properties = new Properties();
            Session session;
            String SMTP_HOST = "192.168.1.103";
            properties.put("mail.smtp.host", SMTP_HOST);
            properties.put("mail.smtp.port","25");
            properties.put("mail.smtp.auth","true");

            session = Session.getDefaultInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("test2@fmail.com","1");
                        }
            });
            Store store = session.getStore("pop3");
            store.connect(SMTP_HOST,"test2@fmail.com","1");
            Folder folder = store.getFolder("inbox");

            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();

            for(Message message : messages){
                POP3Folder pf = (POP3Folder)folder;
                Email email = new Email();
                email.setMessage((String) message.getContent());
                email.setFrom(message.getFrom()[0].toString());
                email.setObjet(message.getSubject());
                email.setCreatedAt(message.getSentDate());
                email.setUuid(pf.getUID(message));
                emails.add(email);
            }


            folder.close(true);
            store.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return emails;
    }

}
