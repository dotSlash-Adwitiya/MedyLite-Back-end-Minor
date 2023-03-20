package com.luv2code.springboot.medylite.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.medylite.entity.Chemist;
import com.luv2code.springboot.medylite.entity.Medicine;
import com.luv2code.springboot.medylite.entity.Shop;
import com.luv2code.springboot.medylite.entity.Symptom;
import com.luv2code.springboot.medylite.entity.Users;
import com.luv2code.springboot.medylite.response.ResponseHandler;
import com.luv2code.springboot.medylite.service.MedyliteService;

@RestController
@RequestMapping("/medylite")
public class MedyliteRestController {

	private MedyliteService medyliteService;
	
	@Autowired
	public MedyliteRestController(MedyliteService theChemistService)
	{
		medyliteService = theChemistService;
	}

	@GetMapping("/hello")
	public String heelo()
	{
		return "Welcome to medylite";
	}
	
	///////FOR CHEMIST>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@GetMapping("/chemist")
	public List<Chemist> getChem()
	{
		return medyliteService.chemFind();
	}
	@PostMapping("/chemist")
	public Chemist SaveChemist(@RequestBody Chemist theChemist)
	{
		theChemist.setId(0);
		medyliteService.saveChem(theChemist);
		return theChemist;
	}
	
	@PutMapping("/chemist")
	public Chemist updateEmployee(@RequestBody Chemist theChemist)
	{
		medyliteService.saveChem(theChemist);
		return theChemist;
	}
	
	@GetMapping("/chemist/{chemistId}")
	public Chemist getChemist(@PathVariable int chemistId)
	{
		Chemist theChemist = new Chemist();
		theChemist = medyliteService.findByIdChem(chemistId);
		
		if(theChemist == null)
		{
			throw new RuntimeException("Chemist id not found -" + chemistId);
		}
		return theChemist;
	}
	
	@DeleteMapping("/chemist/{chemistId}")
	public String DeleteByIdChem(@PathVariable int chemistId)
	{
		Chemist tempChemist = medyliteService.findByIdChem(chemistId);
		
		if(tempChemist == null)
		{
			throw new RuntimeException("Chemist id not found -"+ chemistId);
		}
		
		medyliteService.DeleteByIdChem(chemistId);
		return "Delete chemist id - "+ chemistId;
				
	}
	
	//////USER>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@GetMapping("/user")
	public List<Users> getUser()
	{
		return medyliteService.findUser();
	}
	
	@GetMapping("/user/{userId}")
	public Users findById(@PathVariable int userId)
	{
		Users theUser = new Users();
		theUser = medyliteService.findByIdUser(userId);
		
		if(theUser == null)
		{
			throw new RuntimeException("Chemist id not found -" + userId);
		}
		return theUser;
	}
	
	@PostMapping("/user")
	public Users SaveUser(@RequestBody Users theUser)
	{
		theUser.setId(0);
		medyliteService.saveUser(theUser);
		return theUser;
	}
	
	@PutMapping("/user")
	public Users updateEmployee(@RequestBody Users theUser)
	{
		medyliteService.saveUser(theUser);
		return theUser;
	}
	
	@DeleteMapping("/user/{userId}")
	public String DeleteByIdUser(@PathVariable int userId)
	{
	    Users tempUser = medyliteService.findByIdUser(userId);
		
		if(tempUser == null)
		{
			throw new RuntimeException("Chemist id not found -"+ userId);
		}
		
		medyliteService.DeleteByIdUser(userId);
		return "Delete chemist id - "+ userId;
				
	}
	
	//Medicine>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@GetMapping("/medicine")
	public List<Medicine> getMedicine()
	{
		return medyliteService.mediFind();
	}
	
	@GetMapping("/medicine/{medicineId}")
	public Medicine findByIdMedi(@PathVariable int medicineId)
	{
		Medicine theMedicine = new Medicine();
		theMedicine = medyliteService.findByIdMedi(medicineId);
		
		if(theMedicine == null)
		{
			throw new RuntimeException("Chemist id not found -" + medicineId);
		}
		return theMedicine;
	}
	
	@PostMapping("/medicine")
	public Medicine SaveMedi(@RequestBody Medicine theMedicine)
	{
	
		medyliteService.saveMedi(theMedicine);
		return theMedicine;
	}
	
	@PutMapping("/medicine")
	public Medicine updateMedicine(@RequestBody Medicine theMedicine)
	{
		medyliteService.saveMedi(theMedicine);
		return theMedicine;
	}
	
	@DeleteMapping("/medicine/{medicineId}")
	public String DeleteByIdMedi(@PathVariable int mediId)
	{
	    Medicine tempMedi = medyliteService.findByIdMedi(mediId);
		
		if(tempMedi == null)
		{
			throw new RuntimeException("Chemist id not found -"+ mediId);
		}
		
		medyliteService.DeleteByIdUser(mediId);
		return "Delete chemist id - "+ mediId;
				
	}
	
	//Symptom>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	@GetMapping("/symptom")
	public List<Symptom> getSymptom()
	{
		return medyliteService.sympFind();
	}
	
	@GetMapping("/symptom/{symptomId}")
	public Symptom getSymtpmById(@PathVariable int symptomId )
	{
		Symptom theSymptom = new Symptom();
		theSymptom = medyliteService.findByIdSymp(symptomId);
		
		if(theSymptom == null)
		{
			throw new RuntimeException("Chemist id not found -" + symptomId);
		}
		return theSymptom;
	}
	
	@PostMapping("/symptom")
	public Symptom SaveSymp(@RequestBody Symptom theSymptom)
	{
	
		medyliteService.saveSymp(theSymptom);
		return theSymptom;
	}
	
	@PutMapping("/symptom")
	public Symptom updateSymptom(@RequestBody Symptom theSymptom)
	{
		medyliteService.saveSymp(theSymptom);
		return theSymptom;
	}
	
	@DeleteMapping("/symptom/{symptomId}")
	public String DeleteByIdSymp(@PathVariable int symptomId)
	{
	    Symptom tempSymptom = medyliteService.findByIdSymp(symptomId);
		
		if(tempSymptom == null)
		{
			throw new RuntimeException("Chemist id not found -"+ symptomId);
		}
		
		medyliteService.DeleteByIdSymp(symptomId);
		return "Delete Symptom id - "+ symptomId;
				
	}
	
	//For many to many relationship
	
	@GetMapping("/shops")
	public List<Shop> getShop()
	{
		return medyliteService.shopFind();
	}
	
	@GetMapping("/shop/{shopId}")
	public Shop getByShopId(@PathVariable int shopId )
	{
		Shop theShop = new Shop();
		theShop = medyliteService.findByIdshop(shopId);
		
		if(theShop == null)
		{
			throw new RuntimeException("Shop id not found -" + shopId);
		}
		return theShop;
	}
	
	// passing value in controller as array@PathVariable int shopId ,
	@PutMapping("/addMedi/{shopId}")
	public Shop assignMedicineTOShop(@PathVariable int shopId ,@RequestParam("medi") List<Integer> medi )
	{
		return medyliteService.assigningMedicineToShop(shopId, medi);
	}
	
	
//	@PutMapping("/add/{shopId}/shop/{mediId}")
//	public Shop assignMedicine(@PathVariable int shopId, @PathVariable int mediId)
//	{
//		return medyliteService.assigningMedicineToShop(shopId, mediId);
//	}
	
	//For assigning medicine to the particular symptom
	
	@PutMapping("/add/{symptomId}/symptom/{medicineId}")
	public Symptom assigningMedicineToSymptoms(@PathVariable int symptomId, @PathVariable int medicineId)
	{
		return medyliteService.assignMedicineToSymptom(symptomId,medicineId);
	}
	
	// for deleting medicine of a indivisual shop
	@PutMapping("/shop/{shopId}/medi/{mediId}")
	public String deleteMedicineOfShop(@PathVariable int shopId ,@PathVariable int mediId)
	{
		return medyliteService.deleteMedicineOfShop(shopId,mediId);
	}
	
	//for LOG IN
	
	@PostMapping("/logUser/{phoneNo}/{pass}")
	public ResponseEntity<Object> checkUserAndPassForUser(@PathVariable String phoneNo, @PathVariable String pass) {
		
		if(phoneNo.length() != 10)
			return new ResponseEntity<>("Incorrect Phone !", HttpStatus.LENGTH_REQUIRED);
		
		Users user = medyliteService.checkPhoneAndPass(phoneNo, pass);
		
		if(user == null)
			return ResponseHandler.generateResponse("Incorrect Password / Phone no", HttpStatus.BAD_REQUEST, null);
		return ResponseHandler.generateResponse("You have succesfully logged in !", HttpStatus.ACCEPTED, user);
		
//		return new ResponseEntity<>("correct Password !", HttpStatus.OK);
		
	}
	
	@PostMapping("/logChem/{phoneNo}/{pass}")
	public ResponseEntity<Object> checkUserAndPassForChemist(@PathVariable String phoneNo, @PathVariable String pass) 
	{
		
		if(phoneNo.length() != 10)
			return new ResponseEntity<>("Incorrect Phone !", HttpStatus.LENGTH_REQUIRED);
		
		Chemist chemist = medyliteService.checkPhoneAndPassForChemist(phoneNo, pass);
		
		if(chemist == null)
			return ResponseHandler.generateResponse("Incorrect Password / Phone no", HttpStatus.BAD_REQUEST, null);
		return ResponseHandler.generateResponse("You have succesfully logged in !", HttpStatus.ACCEPTED, chemist);
		
		
		
		
		
	}
	
}
