package com.medical.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.medical.model.Doctor;
 

 
@Service("mailService")
public class MailServiceImpl {
 
    @Autowired
    JavaMailSender mailSender;
 
    public void sendEmail(Doctor mail) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
 
        try {
 
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
 
            mimeMessageHelper.setSubject(mail.getMail_subject());
            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailfrom(), "CREDI HEALTH"));
            mimeMessageHelper.setTo(mail.getMailed());
            mimeMessageHelper.setText(mail.getMail_content());
            
            mailSender.send(mimeMessageHelper.getMimeMessage());
 
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
}