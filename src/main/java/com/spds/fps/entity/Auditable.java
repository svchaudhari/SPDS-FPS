package com.spds.fps.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.spds.fps.audit.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

	@Column(name = "is_active")
	private boolean active = true;

	@Column(name = "is_deleted")
	private boolean deleted = false;

	@CreatedBy
	@Column(name = "created_by")
	private Long createdBy;

	@CreatedDate
	@Column(name = "created_on")
	private LocalDateTime  createdOn;

	@LastModifiedBy
	@Column(name = "updated_by")
	private Long updatedBy;

	@LastModifiedDate
	@Column(name = "updated_on")
	private LocalDateTime  updatedOn;

}
