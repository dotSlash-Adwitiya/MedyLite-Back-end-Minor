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
@Table(name="chem_address")
public class Chem_Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="stateId")
	private State stateId;
	
	
	@Column(name="city")
	private String city;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="local_address")
	private String localAddress;
	
	public Chem_Address()
	{
		
	}

	public Chem_Address(State stateId, String city, int pincode, String localAddress) {
	
		this.stateId = stateId;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
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
		return "Chem_Address [id=" + id + ", stateId=" + stateId + ", city=" + city + ", pincode=" + pincode
				+ ", localAddress=" + localAddress + "]";
	}

	
	
}
