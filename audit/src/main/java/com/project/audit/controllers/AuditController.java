package com.project.audit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.audit.entities.AuditLogs;
import com.project.audit.service.AuditService;

@RestController
@RequestMapping("/audit")
public class AuditController {
	
	
	@Autowired
	private AuditService auditService;
	
	@PostMapping("/log")
	public String addAuditLog(@RequestBody AuditLogs audit) {
		
		auditService.addAudit(audit);
		return "Audit log added!";
	}
}
