package com.luv2code.springboot.medylite.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.luv2code.springboot.medylite.entity.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {
	
	public List<Users> findAll();
	public Users findByPhoneNo(String phoneNo);
	public Users findByPassword(String pass);

}
