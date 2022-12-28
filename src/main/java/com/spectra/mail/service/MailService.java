package com.spectra.mail.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.spectra.mail.dto.MailDTO;
import com.spectra.mail.entity.Mail;
import com.spectra.mail.repo.MailRepo;
import com.spectra.mail.utils.MailUtils;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MailService {

	@Autowired
	MailRepo mailRepo;

	@Autowired
	JavaMailSender sender;
	
	@Autowired
	Environment environment;
	
	@Autowired 
	MailUtils utils;

	public void saveMailDetails(MailDTO mailDto) {
		log.info("#### Saving record!!");
		Mail mail = new Mail();
		BeanUtils.copyProperties(mailDto, mail);
		log.info("#### Record Saved!!");
		mailRepo.save(mail);
	}

	public MailDTO getMailDetails(String componentId) {
		log.info("#### Fetching record!!");
		MailDTO mailDto = new MailDTO();
		BeanUtils.copyProperties(mailRepo.findTop1ByComponentId(componentId), mailDto, "id");
		log.info("#### Record fetched!!");
		return mailDto;
	}

	public void sendMail(String componentId) {
		log.info("#### Mail sending process started!!");
		Mail mail = mailRepo.findTop1ByComponentId(componentId);
		utils.sendMail(componentId, mail, environment.getRequiredProperty("spring.mail.username"));
		log.info("#### Mail Sent!!");
	}
}
