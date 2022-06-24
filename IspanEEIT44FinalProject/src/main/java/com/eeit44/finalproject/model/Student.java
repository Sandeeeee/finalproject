package com.eeit44.finalproject.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String classno;
	private Integer number;
	private String phone;
	private String address;
	private String gender;
	private LocalDate birthday;
	private byte[] photo;
	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "appUser_id")
//	private AppUser appUser;
//	
	
	
}
