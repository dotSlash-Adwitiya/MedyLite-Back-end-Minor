package com.luv2code.springboot.medylite.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.luv2code.springboot.medylite.dao.ChemistRepository;
import com.luv2code.springboot.medylite.dao.MedicineRepository;
import com.luv2code.springboot.medylite.dao.ShopRepository;
import com.luv2code.springboot.medylite.dao.SymptomRepository;
import com.luv2code.springboot.medylite.dao.UserRepository;
import com.luv2code.springboot.medylite.entity.Chemist;
import com.luv2code.springboot.medylite.entity.Medicine;
import com.luv2code.springboot.medylite.entity.Shop;
import com.luv2code.springboot.medylite.entity.Symptom;
import com.luv2code.springboot.medylite.entity.Users;

@Service
public class MedyliteServiceImpl implements MedyliteService {

	private ChemistRepository chemistRepository;
	
	private UserRepository userRepository;
	
    private MedicineRepository medicineRepository;
    
    private SymptomRepository symptomRepository;
    
    private ShopRepository shopRepository;
	
	@Autowired
	public MedyliteServiceImpl(ChemistRepository theChemistRepository,UserRepository theUserRepository,
			MedicineRepository theMedicineRepository, SymptomRepository theSymptomRepository , ShopRepository theShopRepository)
	{
		chemistRepository = theChemistRepository;
		userRepository = theUserRepository;
		medicineRepository = theMedicineRepository;
		symptomRepository = theSymptomRepository;
		shopRepository = theShopRepository;
	}
	
	//FOR CHEMIST>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
	public void saveChem(Chemist chemist) {
		
	    chemistRepository.save(chemist);
	}

	@Override
	public List<Chemist> chemFind() {
		
		return chemistRepository.findAll();
	}

	@Override
	public Chemist findByIdChem(int theId) {
		Optional<Chemist> result = chemistRepository.findById(theId);
		
		Chemist theChemist =null;
		if(result.isPresent()) {
			theChemist = result.get();
		}
		else
		{
			//we didn't find the employee
			throw new RuntimeException("Did not find chemist id - "+ theId);
		}
		return theChemist;
	}

	@Override
	public void DeleteByIdChem(int theId) {
		
		chemistRepository.deleteById(theId);
		
	}
	
	// FOR USER>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void saveUser(Users theUser) {
		
		userRepository.save(theUser);
		
	}

	@Override
	public List<Users> findUser() {
		
		return userRepository.findAll();
		
	}

	@Override
	public Users findByIdUser(int theId) {
		
        Optional<Users> result = userRepository.findById(theId);
		
		Users theUser =null;
		if(result.isPresent()) {
			theUser = result.get();
		}
		else
		{
			//we didn't find the employee
			throw new RuntimeException("Did not find user id - "+ theId);
		}
		return theUser;
	}

	@Override
	public void DeleteByIdUser(int theId) {
		
		userRepository.deleteById(theId);
	
	}
	
	//FOR MEDICINE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void saveMedi(Medicine medicine) {
		
		medicineRepository.save(medicine); 
		
	}

	@Override
	public List<Medicine> mediFind() {
		
		return medicineRepository.findAll();
	}

	@Override
	public Medicine findByIdMedi(int theId) {
		
		Optional<Medicine> result = medicineRepository.findById(theId);
		
		Medicine theMedicine =null;
		if(result.isPresent()) {
			theMedicine = result.get();
		}
		else
		{
			//we didn't find the medicine
			throw new RuntimeException("Did not find Medicine id - "+ theId);
		}
		return theMedicine;
	}

	@Override
	public void DeleteByIdMedi(int theId) {
		
		medicineRepository.deleteById(theId);
	}
	
	// SYMPTOm>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void saveSymp(Symptom symptom) {
		
		symptomRepository.save(symptom);
	}

	@Override
	public List<Symptom> sympFind() {
		
		return symptomRepository.findAll();
	}

	@Override
	public Symptom findByIdSymp(int theId) {
		
        Optional<Symptom> result = symptomRepository.findById(theId);
		
		Symptom theSymptom =null;
		if(result.isPresent()) {
			theSymptom = result.get();
		}
		else
		{
			//we didn't find the medicine
			throw new RuntimeException("Did not find Symptom id - "+ theId);
		}
		return theSymptom;
	}

	@Override
	public void DeleteByIdSymp(int theId) {
		
		symptomRepository.deleteById(theId);
	}

	// FOR Many to Many relationship>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// method for adding medicine in a shop
//	@Override
//	public Shop assigningMedicineToShop(int shopId, int mediId) {
//		
//		Shop shop = shopRepository.findById(shopId).get();
//		Medicine medicine = medicineRepository.findById(mediId).get();
//		
//		System.out.println("shop "+shop);
//		System.out.println("Medicine "+medicine);
//		
//		shop.addMedicine(medicine);
//		
//		shopRepository.save(shop);
//		return shop;
//	}
	
	@Override
	public Shop assigningMedicineToShop(int shopId, List<Integer> medi) {
		
		Shop shop =shopRepository.findById(shopId).get();
		
		for(Integer id : medi)
		{
			Medicine medicine = medicineRepository.findById(id).get();
			shop.addMedicine(medicine);
			shopRepository.save(shop);
		}
		return shop;
	}
	
	//adding medicine to a symptom
	@Override
	public Symptom assignMedicineToSymptom(int symptomId, int medicineId) {

		Symptom symptom = symptomRepository.findById(symptomId).get();
		Medicine medicine  = medicineRepository.findById(medicineId).get();
		
		symptom.addMedicine(medicine);
		
		symptomRepository.save(symptom);
		return symptom;
	}

	// SHOPS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@Override
	public List<Shop> shopFind() {
		return shopRepository.findAll();
	}

	@Override
	public Shop findByIdshop(int theId) {
		
		Optional<Shop> result = shopRepository.findById(theId);
		
		Shop theShop =null;
		if(result.isPresent()) {
			theShop = result.get();
		}
		else
		{
			//we didn't find the employee
			throw new RuntimeException("Did not find ShopId "+ theId);
		}
		return theShop;
	}
	
	
   //
	@Override
	public String deleteMedicineOfShop(int shopId, int mediId) {
		
		Shop shop = shopRepository.findById(shopId).get();
		Medicine medicine = medicineRepository.findById(mediId).get();
	
	    shop.removeMedi(medicine);
	    shopRepository.save(shop);
	    return "medicine is removed";
	}

	//* Check if the phone and password is correct entered by the USER
	//* Security API
	public Users checkPhoneAndPass(String phoneNo, String pass) {
		Users user1 = userRepository.findByPassword(pass);
		Users user2 = userRepository.findByPhoneNo(phoneNo);
		
		if(user1.hashCode()== user2.hashCode())
			return user1;
		else
			return null;
	}

	//* Check if the phone and password is correct entered by the CHEMIST
	//* Security API
	@Override
	public Chemist checkPhoneAndPassForChemist(String phoneNo, String pass) {

		Chemist chemist1= chemistRepository.findByPassword(pass);
		Chemist chemist2 = chemistRepository.findByPhoneNo(phoneNo);
		
		if(chemist1.hashCode()== chemist2.hashCode())
			return chemist1;
		else
			return null;
	}
	
}
