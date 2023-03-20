package com.luv2code.springboot.medylite.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="med_id")
	private int id;
	
	@Column(name="name_M")
	private String name;
	
	@Column(name="info")
	private String information;
	
	@Column(name="effectivness")
	private String effectiveness;
	
	
	@ManyToMany(fetch=FetchType.LAZY,
    		cascade= {CascadeType.PERSIST, CascadeType.MERGE,
  				  CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(
			name="shop_medicine",
			joinColumns=@JoinColumn(name="med_id"),
			inverseJoinColumns=@JoinColumn(name="shop_id")
			)
    private List<Shop> shop;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY,
    		cascade= {CascadeType.PERSIST, CascadeType.MERGE,
  				  CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(
			name="symptom_medicine",
			joinColumns=@JoinColumn(name="med_id"),
			inverseJoinColumns=@JoinColumn(name="symptom_id")
			) 
	private List<Symptom> symptom;
	
	public Medicine()
	{
		
	}

	
	public Medicine(String name, String information, String effectiveness) {
	
		this.name = name;
		this.information = information;
		this.effectiveness = effectiveness;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getInformation() {
		return information;
	}


	public void setInformation(String information) {
		this.information = information;
	}


	public String getEffectiveness() {
		return effectiveness;
	}


	public void setEffectiveness(String effectiveness) {
		this.effectiveness = effectiveness;
	}


	public List<Symptom> getSymptom() {
		return symptom;
	}


	public void setSymptom(List<Symptom> symptom) {
		this.symptom = symptom;
	}


	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}


	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", information=" + information + ", effectiveness="
				+ effectiveness + ", shop=" + shop + ", symptom=" + symptom + "]";
	}

	


	
	
	
}
