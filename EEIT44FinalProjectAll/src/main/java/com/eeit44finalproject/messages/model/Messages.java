package com.eeit44finalproject.messages.model;




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
	private	String	messageId ;
	
	@Column(name="text")
	private String text;

	
	@Column(name="senderId")
	private	String senderId ;
	
	@Column(name="receiverId")
	private	String receiverId;
	
	@Column(name="created")
	private	String created;
	
	@Column(name="channel")
	private	String channel;

}
