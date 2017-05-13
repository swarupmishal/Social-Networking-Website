package com.swarup.pojo;

import javax.annotation.Generated;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="addresstable")
public class Address {
	
	@Id @GeneratedValue
	@Column(name="addressID")
	private long addressID; 
	
	@Column(name="street")
    private String street;
	
	@Column(name="aptNo")
    private int aptNo;
	
	@Column(name="zip")
	private int zip;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

//	@OneToOne(fetch = FetchType.EAGER)
//	@PrimaryKeyJoinColumn(name="id")
//	private User user;
	
	
	
//    public int getAddressID() {
//        return addressID;
//    }
//
//    public void setAddressID(int addressID) {
//        this.addressID = addressID;
//    }

   


	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}



	public long getAddressID() {
		return addressID;
	}



	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
        this.street = street;
    }

    public int getAptNo() {
        return aptNo;
    }

    public void setAptNo(int aptNo) {
        this.aptNo = aptNo;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}