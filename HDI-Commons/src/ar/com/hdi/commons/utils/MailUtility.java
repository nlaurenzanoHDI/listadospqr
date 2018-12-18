package ar.com.hdi.commons.utils;

import java.awt.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.handlers.multipart_mixed;

public class MailUtility {

	/**
	 * TODO move to LDAPUtility? Length of secure string used for email recovery (does not include length of expiration date)
	 */
	public static final int SECURE_TOKEN_LENGTH = 26;

	/**
	 * Default content type
	 */
	public static final String CONTENTTYPE_TEXT_PLAIN = "text/plain; charset=utf-8";
	public static final String CONTENTTYPE_HTML = "text/html; charset=utf-8";

	/**
	 * Return secure token for mail recovery
	 * 
	 * @param expirationDate The expiration date is appended to the end of the token
	 * @return secure token + expirationDate
	 * @see {@link HDIUtils#getSecureToken(int)}
	 */
	public static String getSecureToken(String expirationDate) {
		return HDIUtils.getSecureToken(SECURE_TOKEN_LENGTH) + expirationDate;
	}

	/**
	 * Send mail to destinationAddress with subject and body messageBody
	 * 
	 * @param destinationAddress Email addresses separated by comma
	 * @param subject
	 * @param messageBody
	 * @param from if null, smtp username will be used
	 * @param contentType content type of email
	 * @throws HDIException
	 */
	public static void sendEmail(java.util.List<String> destinationsAddress, java.util.List<String> destinationsName, String subject, String messageBody, String from, String fromName, String contentType, Map<String, Object> mailConfig, String filename) throws Exception {
		
		try {
			if (destinationsAddress != null) {
				
				Properties props = new Properties();
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.host", mailConfig.get("server").toString());
		        props.put("mail.smtp.port", "25");
				
				final String username = mailConfig.get("user").toString();
				final String password = mailConfig.get("pass").toString();
				Session mailSession = Session.getInstance(props,
						new javax.mail.Authenticator() {
							protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
								return new javax.mail.PasswordAuthentication(username, password);
							}
						});

				Message msg = new MimeMessage(mailSession);

				msg.setFrom(new InternetAddress(from, fromName));
//				InternetAddress to = null;
//				if(destinationsAddress.size() == 2 ) {
//					InternetAddress to = new InternetAddress(destinationsAddress.get(1), destinationsName.get(1));
//				}else if(destinationsAddress.size() == 3 ) {
//					cc = destinationsAddress.get(1);
//					cco = destinationsAddress.get(2);
//				}

				if(destinationsAddress.size() == 1 )
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationsAddress.get(0), destinationsName.get(0)));
				if(destinationsAddress.size() == 2 ){
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationsAddress.get(0), destinationsName.get(0)));
					msg.addRecipient(Message.RecipientType.CC, new InternetAddress(destinationsAddress.get(1), destinationsName.get(1)));
				}
				if(destinationsAddress.size() == 3 ) {
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationsAddress.get(0), destinationsName.get(0)));
					msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(destinationsAddress.get(2), destinationsName.get(2)));
					msg.addRecipient(Message.RecipientType.CC, new InternetAddress(destinationsAddress.get(1), destinationsName.get(1)));
				}
				
				if(subject == null || subject.isEmpty())
					msg.setSubject(subject);
				else
					msg.setSubject(subject);
				
				boolean mime = mailConfig.get("mime")==null?false:true;
				
				if(mime) {
					Multipart multiPart = new MimeMultipart();

					MimeBodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setContent(messageBody, "text/html");
//					messageBodyPart.setText(messageBody);
					multiPart.addBodyPart(messageBodyPart);

					MimeBodyPart attachment = new MimeBodyPart();
					attachment.attachFile(filename);
					multiPart.addBodyPart(attachment);
					msg.setContent(multiPart);
				} else {
					msg.setContent(messageBody, contentType);
				}
				
				Transport.send(msg);
			}
		} catch (MessagingException e) {
			throw new Exception(e);
		}
	}

	/**
	 * {@link MailUtility#sendEmail(String, String, String, String, String) sendEmail} with default content type
	 * {@link MailUtility#CONTENTTYPE_TEXT_PLAIN}
	 */
	public static void sendEmail(java.util.List<String> destinationsAddress, java.util.List<String> destinationsName, String subject, String messageBody, String from, String fromName, Map<String, Object> mailConfig, String filename) throws Exception {
		sendEmail(destinationsAddress, destinationsName, subject, messageBody, from, fromName, CONTENTTYPE_TEXT_PLAIN, mailConfig, filename);
	}
}