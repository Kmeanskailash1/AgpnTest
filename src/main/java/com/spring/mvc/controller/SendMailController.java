package com.spring.mvc.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.model.FormData;

@RestController
public class SendMailController {

	private final JavaMailSender javaMailSender;

	@Value("${spring.mail.username}") // Injects email sender's username from application.properties
	private String senderEmail;

	@Value("${receiveMailAt}") // Injects email sender's username from application.properties
	private String receiveEmailAt;

	SendMailController(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@PostMapping("sendMail")
	public String sendMail(@RequestBody FormData formData) {

		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(senderEmail); // sender's email address
			mailMessage.setTo(receiveEmailAt); // Receiver mail
			mailMessage.setSubject("Important ! Message from AGPN portal , Timestamp: " + getTimeStamp());
			mailMessage.setText("Dear Team,\nPlease take care of the concern below." + "\nFrom:" + formData.getName()
					+ ",\nPhone:" + formData.getPhone() + "\nEmail:" + formData.getEmail() + "\nMessage:"
					+ formData.getMessage() + "\n\n\nThank you !");
			System.out.println("Mail sent successfully");
			// Send email
			javaMailSender.send(mailMessage);

			return "Your message has been sent successfully.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Unable to send email. Please try again later.";
		}
	}

	public String getTimeStamp() {
		// Define the IST time zone
		ZoneId istZoneId = ZoneId.of("Asia/Kolkata");

		// Get the current date and time in the specified time zone
		ZonedDateTime nowInIST = ZonedDateTime.now(istZoneId);

		// Define the desired format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

		// Format the timestamp
		String formattedTimestamp = nowInIST.format(formatter);
		return formattedTimestamp;
	}

}
