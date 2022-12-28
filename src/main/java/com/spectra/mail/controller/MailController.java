package com.spectra.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spectra.mail.config.Bean1;
import com.spectra.mail.dto.MailDTO;
import com.spectra.mail.service.MailService;

@RestController
@RequestMapping("/mail")
@CrossOrigin("*")
public class MailController {

	@Autowired
	MailService mailService;
	
	@Autowired
	Bean1 bean;
	
	@PostMapping("/v1/save")
	public ResponseEntity<String> template(@RequestBody MailDTO mailDto){
		mailService.saveMailDetails(mailDto);
		return new ResponseEntity<>("Record saved to DB !!",HttpStatus.CREATED);
	}
	
	@GetMapping("/v1/fetch")
	public ResponseEntity<MailDTO> fetch(@RequestParam(name = "componentId", required = true) String componentId){
		return ResponseEntity.ok(mailService.getMailDetails(componentId));
	}
	
	@PostMapping("/v1/shoot-mail")
	public ResponseEntity<String> shootMail(@RequestParam String componentId){
		mailService.sendMail(componentId);
		return new ResponseEntity<>("Mail sent successfully!!",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/bean-test")
	public ResponseEntity<String> beanTest() {
		return new ResponseEntity<>(bean.getHelloText(),HttpStatus.OK);
	}
}
