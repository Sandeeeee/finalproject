package com.eeit44.finalproject.model;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="messages")
public class Messages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="messageId")
	private	int	messageId ;
	
	@Column(name="text")
	private String text;

	
	@Column(name="senderId")
	private	int senderId ;
	
	@Column(name="receiverId")
	private	int receiverId;
	
	@Column(name="created")
	private	String created;
	
	@Column(name="channel")
	private	String channel;

}
