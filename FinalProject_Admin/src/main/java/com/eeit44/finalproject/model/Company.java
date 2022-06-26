package com.eeit44.finalproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//CompanyBean
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "companyId")
	private Integer companyId;

	@Column(name = "taxId")
	private int taxId;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "contact")
	private String contact;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "line")
	private String line;

	@Column(name = "industry")
	private String industry;

	@Column(name = "address")
	private String address;

	
	@Column(name = "website")
	private String website;

	@Column(name = "department")
	private String department;

	@Column(name = "created_at")
	private Date created_at;

	@Column(name = "modified_at")
	private Date modified_at;

}
