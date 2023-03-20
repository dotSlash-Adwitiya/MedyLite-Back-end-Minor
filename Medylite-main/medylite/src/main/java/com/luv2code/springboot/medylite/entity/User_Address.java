package com.luv2code.springboot.medylite.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_address")
public class User_Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="state_id")
	private State stateId;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pincode")
	private long pincode;
	
	@Column(name="local_address")
	private String localAddress;
	
    public User_Address()
    {
    	
    }

	public User_Address( String city, long pincode, String localAddress) {
		
		this.city = city;
		this.pincode = pincode;
		this.localAddress = localAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public State getStateId() {
		return stateId;
	}

	public void setStateId(State stateId) {
		this.stateId = stateId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	@Override
	public String toString() {
		return "User_Address [id=" + id + ", stateId=" + stateId + ", city=" + city + ", pincode=" + pincode
				+ ", localAddress=" + localAddress + "]";
	}
    
    

}
