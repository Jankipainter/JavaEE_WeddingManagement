/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmailService;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author pc
 */
public class EmailService {

    public static Boolean sendFromGMail(String toEmail, String subject, String body) {
        String host = "smtp.gmail.com";
        final String user = "weddingproject3307@gmail.com";//change accordingly  
        final String password = "Weddy@123";//change accordingly  
        String to = toEmail;

        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.transport.protocol", "smtp");
        p.put("mail.smtp.user", user);
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
//       // p.put("mail.smtp.socketFactory.port", "465");
//        p.put("mail.smtp.socketFactory.fallback", "false");
//        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.starttls.required", "true");

      
        
         try { 
             
               Session session = Session.getInstance(p,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject(subject);  
     message.setText(body);  

    //send the message  
    //Transport.send(message);  
    Transport transport = session.getTransport("smtp");
    transport.connect("smtp.gmail.com",user, password);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();

     System.out.println("message sent successfully..."); 
     return true;

     } catch (MessagingException e) {e.printStackTrace(); return false;} 
    }

}
