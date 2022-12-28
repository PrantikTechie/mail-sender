package com.spectra.mail.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MailDTO {

	@JsonProperty("component_id")
	private String componentId;

	@JsonProperty("subject")
	private String subject;

	@JsonProperty("body")
	private String body;

	@JsonProperty("recipients")
	private List<String> recipients;

}
