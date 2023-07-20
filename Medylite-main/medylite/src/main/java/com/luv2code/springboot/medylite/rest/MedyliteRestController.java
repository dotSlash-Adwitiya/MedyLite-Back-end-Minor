package com.luv2code.springboot.medylite.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.medylite.entity.Chemist;
import com.luv2code.springboot.medylite.entity.Users;
import com.luv2code.springboot.medylite.service.ChemistService;

@RestController
@RequestMapping("/api")
public class MedyliteRestController {

	private ChemistService chemistService;

	//* Use of constructor injection to access the next layer (Service Layer)
	@Autowired
	public MedyliteRestController(ChemistService theChemistService)
	{
		chemistService = theChemistService;
	}

	@GetMapping("/hello")
	public String hello()
	{
		return "Welcome to medylite";
	}
	
	//            ---------------------------- FOR CHEMIST -------------------------------------------
	@GetMapping("/chemists")
	public List<Chemist> findAll()
	{
		return chemistService.chemFind();
	}

	@PostMapping("/chemists")
	public Chemist SaveChemist(@RequestBody Chemist theChemist)
	{
		//* setting id to 0 indicates that the entity is NEW !
		theChemist.setId(0);
		chemistService.saveChem(theChemist);
		return theChemist;
	}

	@PutMapping("/chemists")
	public Chemist updateChemist(@RequestBody Chemist theChemist)
	{
		chemistService.saveChem(theChemist);
		return theChemist;
	}

	@GetMapping("/chemists/{chemistId}")
	public Chemist getChemist(@PathVariable int chemistId)
	{
		Chemist theChemist = new Chemist();
		theChemist = chemistService.findByIdChem(chemistId);

		if(theChemist == null) throw new RuntimeException("Chemist id not found -" + chemistId);

		return theChemist;
	}

	@DeleteMapping("/chemists/{chemistId}")
	public String DeleteByIdChem(@PathVariable int chemistId)
	{
		Chemist tempChemist = chemistService.findByIdChem(chemistId);

		if(tempChemist == null)
		{
			throw new RuntimeException("Chemist id not found -"+ chemistId);
		}

		chemistService.DeleteByIdChem(chemistId);
		return "Delete chemist id - "+ chemistId;
	}

	@PutMapping("/users")
	public Users updateChemist(@RequestBody Users theUser)
	{
		chemistService.saveUser(theUser);
		return theUser;
	}


	// ------------------------------------------------ USER ----------------------------------------------------
	@GetMapping("/users")
	public List<Users> getUser()
	{
		return chemistService.findUser();
	}

	@GetMapping("/users/{userId}")
	public Users findById(@PathVariable int userId)
	{
		Users theUser = new Users();
		theUser = chemistService.findByIdUser(userId);

		if(theUser == null)
			throw new RuntimeException("Chemist id not found -" + userId);

		return theUser;
	}

	@PostMapping("/users")
	public Users SaveUser(@RequestBody Users theUser)
	{
		//* setting id to 0 indicates that the entity is NEW !
		theUser.setId(0);
		chemistService.saveUser(theUser);
		return theUser;
	}


	@DeleteMapping("/users/{userId}")
	public String DeleteByIdUser(@PathVariable int userId)
	{
	    Users tempUser = chemistService.findByIdUser(userId);
		
		if(tempUser == null)
		{
			throw new RuntimeException("Chemist id not found -"+ userId);
		}
		
		chemistService.DeleteByIdUser(userId);
		return "Delete chemist id - "+ userId;
	}
	
}
