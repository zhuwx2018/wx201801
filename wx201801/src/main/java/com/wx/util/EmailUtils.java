package com.wx.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailUtils {
	private EmailUtils(){}
	
	public static SimpleMailMessage createMessage(String from, String to[], String context){
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(from);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setText(context);
		return simpleMailMessage;
	}
	
	public static MimeMessageHelper initMimeHelp(JavaMailSenderImpl mailSender, String htmlText, String from, String[] to) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setText(htmlText, true);
			helper.setFrom(from);
			helper.setSubject("红海心动");
			helper.addInline("照片", new File("C:\\Users\\zhugf\\Desktop\\default3.jpg"));
			helper.setTo(to);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return helper;
	}
	
	

}
