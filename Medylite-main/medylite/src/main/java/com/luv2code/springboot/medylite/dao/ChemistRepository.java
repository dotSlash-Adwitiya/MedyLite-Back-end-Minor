package com.luv2code.springboot.medylite.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.luv2code.springboot.medylite.entity.Chemist;


public interface ChemistRepository extends CrudRepository<Chemist, Integer> {

	public List<Chemist> findAll();
	public Chemist findByPhoneNo(String phoneNo);
	public Chemist findByPassword(String pass);

}
