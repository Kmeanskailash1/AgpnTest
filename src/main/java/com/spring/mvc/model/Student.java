package com.spring.mvc.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
	//student details
	@Id
	private String regNo;
	private Integer std;
	private String studentName;
	private String dateOfBirth;
	
	//family details
	private String fatherName;
	private String contactNoFather;
	private String qualificationFather;
	private String occupationFather;
	
	private String motherName;
	private String contactNoMother;
	private String qualificationMother;
	private String occupationMother;
	
	private String guardianName;
	private String guardianContact;
	private String relationWithGuardian;
	
	private String homeAddress;
	private String homePhone;
	
	//History details
	private String dateOfAdmission;
	private String classOfAdmission;
	private String lastSchoolName;
	
	private String addedBy;
	
	@CreationTimestamp(source = SourceType.DB)
	private Timestamp createdAt;
	@UpdateTimestamp(source = SourceType.DB)
	private Timestamp updatedAt;
}
