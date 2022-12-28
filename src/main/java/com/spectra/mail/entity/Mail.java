package com.spectra.mail.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, updatable = false)
	private int id;
	
	@Column(name = "COMPONENT_ID", nullable = false)
	@NotBlank(message = "Component id is required field.")
	private String componentId;
	
	@Column(name = "SUBJECT", nullable = false)
	@NotBlank(message = "Subject is required field.")
	private String subject;
	
	@Column(name = "BODY", nullable = false)
	@NotBlank(message = "Body is required field.")
	private String body;
	
	@ElementCollection
	@Column(name = "RECIPIENTS", nullable = false)
	@NotBlank(message = "Recipients is required field.")
	private List<String> recipients;

}
