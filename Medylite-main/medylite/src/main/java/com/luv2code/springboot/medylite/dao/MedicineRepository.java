package com.luv2code.springboot.medylite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.medylite.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

}
