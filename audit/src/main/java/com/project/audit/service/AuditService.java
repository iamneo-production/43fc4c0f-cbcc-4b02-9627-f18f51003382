package com.project.audit.service;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.audit.entities.AuditLogs;
import com.project.audit.repositories.AuditRepository;

@Service
public class AuditService {
	
	@Autowired
	private AuditRepository auditRepository;
	
	
	public AuditLogs addAudit(AuditLogs audit) {
		audit.setTimeStamp(new Date());
		return auditRepository.save(audit);
		
	}
	
}
