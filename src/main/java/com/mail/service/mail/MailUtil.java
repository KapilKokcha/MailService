package com.mail.service.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	/**
	 * Utility method to send simple HTML email
	 * 
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(String toEmail, String ccEmail, String bccEmail, String subject, String body) {

		final String username = "";
		final String password = "";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");


		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(""));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			if (ccEmail != null && ccEmail.trim().length() != 0) {
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail));
			}

			if (bccEmail != null && bccEmail.trim().length() != 0) {
				message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccEmail));
			}
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
