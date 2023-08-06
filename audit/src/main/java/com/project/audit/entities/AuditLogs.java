package com.project.audit.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="audit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int auditId;
	
	private long customerId;
	
	private boolean status;
	
	@Column(name="requested_on")
	private Date timeStamp;
	
	
}
