/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.ams;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Nimesh
 */
public class Email {

    String recipientEmail;
    String studentname;
    String lec;
    String lectime;

    public Email(String module, String time) {

        Student student = new Student();

        recipientEmail = student.getEmail();
        studentname = student.getFullname();
        lec = module;
        lectime = time;

    }

    public void sendEmail() {

        final String username = "nsbmams@gmail.com";
        final String password = "NSBM@ams";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session;
        session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nsbmams@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipientEmail)
            );
            message.setSubject("Welcome" + studentname);
            message.setText("You have"
                    + lec
                    + "\n\n"
                    + "at"
                    + lectime);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
