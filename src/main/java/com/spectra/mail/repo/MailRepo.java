package com.spectra.mail.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spectra.mail.entity.Mail;

@Repository
public interface MailRepo extends JpaRepository<Mail, Integer> {

	Mail findTop1ByComponentId(String componentId);
}
