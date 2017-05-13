package com.swarup.pojo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="messagetable")
public class Message {
	
	@Id @GeneratedValue
	@Column(name="messageID", unique=true, nullable=false )
	private int messageID;
	
//	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinColumn(name="sender")
	@Column(name="sender")
	private String sender;

	//	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinColumn(name="receiver")
	@Column(name="receiver")
	private String receiver;
    
	@Column(name="message")
	private String message;

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
	
	
	
    
//	@Column(name="messageDate")
//	private Date messageDate;
	
	
	
	
	
	
	
    
    
}
