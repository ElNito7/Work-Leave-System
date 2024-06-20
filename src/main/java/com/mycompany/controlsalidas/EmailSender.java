/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlsalidas;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Keloc
 */
public class EmailSender {
    //contra -> voag kbko oggu pucx
    private static String correoFrom = "kelo.camachoromero@gmail.com";
    private static String contra = "voag kbko oggu pucx";
    private String sendTo;
    private String subject;
    private String content;
    
    private static Properties mProperties = new Properties();
    private Session session;
    private MimeMessage message;
    
    public EmailSender(){}
    public void createEmail(String send, String sub, String c){
        try {
            sendTo = send;
            subject = sub;
            content = c;
            
            //Simple Mail Transfer Protoclol (smtp)
            mProperties.put ("mail.smtp.host", "smtp.gmail.com");
            mProperties.put ("mail.smtp.ssl.trust", "smtp.gmail.com");
            mProperties.setProperty("mail.smtp.starttls.enable", "true");
            mProperties.setProperty("mail.smtp.port", "587");
            mProperties.setProperty("mail.smtp.user", correoFrom);
            mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            mProperties.setProperty("mail.smtp.auth", "true");
            
            session = Session.getDefaultInstance(mProperties);
            
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoFrom));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
            message.setSubject(subject);
            message.setText(content, "ISO-8859-1","html");
        } catch (AddressException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MessagingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void sendEmail(){
        try {
            Transport transport = session.getTransport("smtp");
            transport.connect(correoFrom, contra);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MessagingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
