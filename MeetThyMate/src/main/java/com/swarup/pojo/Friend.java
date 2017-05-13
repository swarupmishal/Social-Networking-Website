package com.swarup.pojo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="friendtable")
public class Friend {
	@Id @GeneratedValue
	@Column(name="friendID")
	private long friendID;
	
	@JoinColumn(name="personID")
	private long personID;
	
	@Column(name="friendUserName")
	private String friendUserName;
	
	
	
	
	
	
	






	





	
	public long getFriendID() {
		return friendID;
	}
	public void setFriendID(long friendID) {
		this.friendID = friendID;
	}
	public long getPersonID() {
		return personID;
	}
	public void setPersonID(long personID) {
		this.personID = personID;
	}
	public String getFriendUserName() {
		return friendUserName;
	}
	public void setFriendUserName(String friendUserName) {
		this.friendUserName = friendUserName;
	}
	
}
