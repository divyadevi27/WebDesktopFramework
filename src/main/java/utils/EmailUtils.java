package utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.File;
import java.util.Properties;

public class EmailUtils {
	// SMTP server configuration
	String host = "smtp.gmail.com";
	final String user = "garima.singhal221285@gmail.com";
	final String password = "gmje ttjh ozdh pjqc";
	String to = "garima.goyal@crestechsoftware.com";
	String filename = "C:\\Users\\Garima.Goyal\\Downloads\\Assesment_20240920_1726820060631.xlsx";

	public void mailSent() {
		// Get system properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");

		// Get the default Session object
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			// Create a default MimeMessage object
			MimeMessage message = new MimeMessage(session);

			// Set From: header field
			message.setFrom(new InternetAddress(user));

			// Set To: header field
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Automated Email Test");

			// Create a multipart message for the email body and attachment
			Multipart multipart = new MimeMultipart();

			// Set the email text
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("This is the email body text.");
			multipart.addBodyPart(messageBodyPart);

			// Attach the file
			messageBodyPart = new MimeBodyPart();						
			File file = new File(filename);
			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(file.getName());
			multipart.addBodyPart(messageBodyPart);

			// Set the complete multipart message to the email message
			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Email sent successfully.");

		} catch (AuthenticationFailedException e) {
			System.err.println("Authentication failed. Please check your email and password.");
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
