package com.spectra.mail.utils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.spectra.mail.entity.Mail;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
public class MailUtils {

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private Configuration config;

	public void sendMail(String componentId, Mail mail, String user) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Map<String, Object> values = new HashMap<>();
			values.put("body", mail.getBody());

			Template template = config.getTemplate("email.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, values);

			for (String to : mail.getRecipients()) {
				helper.setTo(to);
			}
			helper.setText(html, true);
			helper.setSubject(mail.getSubject());
			helper.setFrom(user);

			sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
