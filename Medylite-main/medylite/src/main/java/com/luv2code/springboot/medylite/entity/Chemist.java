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

//JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="chemist")
public class Chemist {
	
	//defining fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="User_Name")
	private String userName;
	
	@Column(name="role_")
	private String role;
	
	@Column(name="phone_No")
	private String  phoneNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="Paasword")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Chem_Address addressId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shop_id")
	private Shop shopId;
	
	public Chemist()
	{
		
	}

	
	
	public Chemist(String userName, String role, String phoneNo, String email, String password, Chem_Address addressId,
			Shop shopId) {

		this.userName = userName;
		this.role = role;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
		this.addressId = addressId;
		this.shopId = shopId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Chem_Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Chem_Address addressId) {
		this.addressId = addressId;
	}

	public Shop getShopId() {
		return shopId;
	}

	public void setShopId(Shop shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Chemist [id=" + id + ", userName=" + userName + ", role=" + role + ", phoneNo=" + phoneNo + ", email="
				+ email + ", password=" + password + ", addressId=" + addressId + ", shopId=" + shopId + "]";
	}

	

	
	
}
