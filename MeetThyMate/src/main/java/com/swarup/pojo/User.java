package com.swarup.pojo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="usertable")
@PrimaryKeyJoinColumn(name="personID")
public class User extends Person{
	
	@Column(name="userName")
    private String userName;
    
	@Column(name="gender")
	private String gender;
    
	@OneToOne
	@JoinColumn(name="addressID")
	private Address address;
    
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="userPassword")
	private String userPassword;
	
	@Column(name="role")
	private String role;
	
	@Column(name="photoName")
	private String photoName;

	@Transient
	private MultipartFile profilePic;
	
	@OneToMany(mappedBy="personID",cascade=CascadeType.ALL)
	private List<Friend> friendList=new ArrayList<Friend>();
	
	
	
	





	public String getPhotoName() {
		return photoName;
	}

	public List<Friend> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<Friend> friendList) {
		this.friendList = friendList;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	
	
	

	
	
	
	
	
	
	

	public MultipartFile getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	

	

    


}
