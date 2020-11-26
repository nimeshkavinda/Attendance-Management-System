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
    String moduleid;
    String lectime;
    String lec;

    public Email(String module, String time) {

        moduleid = module;
        lectime = time;
        getLecture();

    }

    public void getLecture() {

        if (moduleid != null) {

            switch (moduleid) {
                case "1":
                    lec = "International Business";
                    break;
                case "2":
                    lec = "Operations Management";
                    break;
                case "3":
                    lec = "Business Ethics";
                    break;
                case "4":
                    lec = "Management Accounting";
                    break;
                case "5":
                    lec = "International Marketing";
                    break;
                case "6":
                    lec = "SE with Java";
                    break;
                case "7":
                    lec = "Web Development Platforms";
                    break;
                case "8":
                    lec = "Databases";
                    break;
                case "9":
                    lec = "Network Security";
                    break;
                case "10":
                    lec = "Internet of Things";
                    break;
                case "11":
                    lec = "Design Communication";
                    break;
                case "12":
                    lec = "Building Science";
                    break;
                case "13":
                    lec = "Algorithms";
                    break;
                case "14":
                    lec = "Operating Systems";
                    break;
                case "15":
                    lec = "Engineering Mathematics";
                    break;
                case "16":
                    lec = "Digital Marketing";
                    break;
                case "17":
                    lec = "Advertising";
                    break;
                case "18":
                    lec = "Financial Accounting";
                    break;
                case "19":
                    lec = "Taxation";
                    break;
                case "20":
                    lec = "Servers and Datacenters";
                    break;
                case "21":
                    lec = "Incident Prevention";
                    break;
                case "22":
                    lec = "Network Monitoring";
                    break;
                case "23":
                    lec = "Penetration Testing";
                    break;
                case "24":
                    lec = "Design Culture";
                    break;
            }

        }

    }

    public void sendEmail(String email, String name) {

        final String username = "nsbmams@gmail.com";
        final String password = "NSBM@ams";

        Student student = new Student();
        recipientEmail = email;
        studentname = name;

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

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
            message.setSubject("Welcome to Campus " + studentname);
            message.setText("Hi, "
                    + studentname
                    + "\n\n"
                    + "We hope you are having a great day so far."
                    + "\n\n"
                    + "Please find your lecture schedule for today below"
                    + "\n\n"
                    + lec
                    + " at "
                    + lectime);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
