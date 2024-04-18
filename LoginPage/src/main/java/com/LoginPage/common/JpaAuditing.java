package com.LoginPage.common;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class JpaAuditing {

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;
	
	@CreatedDate
	@Column(name = "created_on")
	private LocalDateTime createdOn;
	
	@LastModifiedBy
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@LastModifiedDate
	@Column(name = "modified_on")
	private LocalDateTime modifiedOn;
	
	
//	@Column(name = "deleted_by")
//	private String deletedBy;
//	
//	@Column(name = "deleted_on")
//	private String deletedOn;
	
	@NonNull
    @ApiModelProperty(value = "Valid status", required = true, allowableValues = "Active,Inactive,Pending;")
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status; 

	
}
