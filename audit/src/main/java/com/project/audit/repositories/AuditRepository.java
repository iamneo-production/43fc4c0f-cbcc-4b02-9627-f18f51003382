package com.project.audit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.audit.entities.AuditLogs;

public interface AuditRepository extends JpaRepository<AuditLogs, Integer>{

}
