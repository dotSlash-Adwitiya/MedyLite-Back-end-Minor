package com.luv2code.springboot.medylite.service;

import java.util.List;

import com.luv2code.springboot.medylite.entity.Chemist;
import com.luv2code.springboot.medylite.entity.Medicine;
import com.luv2code.springboot.medylite.entity.Shop;
import com.luv2code.springboot.medylite.entity.Symptom;
import com.luv2code.springboot.medylite.entity.Users;

public interface MedyliteService {

	// for chemist
	public void saveChem(Chemist theChemist);
	
	public List<Chemist> chemFind();
	
	public Chemist findByIdChem(int theId);
	
	public void DeleteByIdChem(int theId);
	
	//for user
	public void saveUser(Users theUser);
	
	public List<Users> findUser();
	
	public Users findByIdUser(int theId);
	
	public void DeleteByIdUser(int theId);
	
	// for medicine 
	
	public void saveMedi(Medicine medicine);
	
	public List<Medicine> mediFind();
	
	public Medicine findByIdMedi(int theId);
	
	public void DeleteByIdMedi(int theId);
	
	// for Symptom
	
	public void saveSymp(Symptom symptom);
	
	public List<Symptom> sympFind();
	
	public Symptom findByIdSymp(int theId);
	
	public void DeleteByIdSymp(int theId);
	
	// for shop
	
	public List<Shop> shopFind();
	public Shop findByIdshop(int theId);
	
	
	//for relationships 
	
	//public Shop assigningMedicineToShop(int shopId,int mediId);
	public Shop assigningMedicineToShop(int shopId,List<Integer> medi);

	public Symptom assignMedicineToSymptom(int symptomId, int medicineId);

	public String deleteMedicineOfShop(int shopId, int mediId);

	
	//for log in 
	public Users checkPhoneAndPass(String phoneNo, String pass);
	
	public Chemist checkPhoneAndPassForChemist(String phoneNo, String pass);
}
