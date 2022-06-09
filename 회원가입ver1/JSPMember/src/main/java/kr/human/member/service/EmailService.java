package kr.human.member.service;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailService {
	private static Session mailSession;
	
	static {
		Properties p = new Properties(); // 정보를 담을 객체
		p.put("mail.smtp.host","smtp.naver.com"); // 네이버 SMTP 또는 gmail SMTP
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		mailSession = Session.getInstance(p, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("shoogal17@naver.com", "자기비번!");
			}
		});
	}
	
	public static void sendMail(String to, String subject, String content) {
		try {
			MimeMessage message = new MimeMessage(mailSession); // 메일의 내용을 담을 객체
			Address fromAddress = new InternetAddress("shoogal17@naver.com");
			message.setFrom(fromAddress);
			Address toAddress = new InternetAddress(to);     // 받는 사람
			message.addRecipient(Message.RecipientType.TO, toAddress);
			message.setSubject(subject);	// 제목
			message.setContent(content, "text/html;charset=UTF-8"); // 내용
			// 전송
			Transport.send(message);
			log.debug("{}에게 메일전송 성공!!!", to);
		} catch (AddressException e) {
			log.debug("에러발생 : {}", e.getMessage());
			e.printStackTrace();
		} catch (MessagingException e) {
			log.debug("에러발생 : {}", e.getMessage());
			e.printStackTrace();
		} 
	}
}
