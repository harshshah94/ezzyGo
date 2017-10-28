package com.app.ezzygo.utils.smtp;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmtpUtils {

	public static boolean sendEmail(String to) {

		final String host = "smtp.gmail.com";
		final String user = "cdacp15@gmail.com";// change accordingly
		final String password = "chdhdiha";// change accordingly
		System.out.println("email id fetched...." + to);

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", "465"); // for SSL -- 465
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		// props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

		// Compose the message
		try {
			Message message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(user, "ezzyGo"));
			} catch (Exception e) {
				e.getMessage();
				System.out
						.println("inside catch of setFrom()... SmtpUtils.java");
			}
			// message.addRecipient(Message.RecipientType.TO,new
			// InternetAddress(to));
			message.addRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("Mail sent !!!!!! ");
			message.setText("This is simple program of sending email using JavaMail API");
			System.out.println("before sending msg...........");
			// send the message
			Transport.send(message);
			System.out.println("message sent successfully...");
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

}
