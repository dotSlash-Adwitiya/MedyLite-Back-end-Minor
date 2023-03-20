package com.luv2code.springboot.medylite.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="symptom")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Symptom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="symptom_name")
	private String symptomName;
	
	@Column(name="image")
	private String image;
	
	@ManyToMany
	@JoinTable(
			name="symptom_medicine",
			joinColumns=@JoinColumn(name="symptom_id"),
			inverseJoinColumns=@JoinColumn(name="med_id")
			)
	private List<Medicine> medicine;
	
	public Symptom()
	{
		
	}

	public Symptom(String symptomName , String image) {
		
		this.symptomName = symptomName;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymptomName() {
		return symptomName;
	}

	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Medicine> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}
	
	//add convenience method
	
	public void addMedicine(Medicine theMedicine)
	{
		if(medicine == null)
		{
			medicine = new ArrayList<>();
		}
	       medicine.add(theMedicine);
				
	}


	@Override
	public String toString() {
		return "Symptom [id=" + id + ", symptomName=" + symptomName + ", image=" + image + ", medicine=" + medicine
				+ "]";
	}

	
	
	
	

}
