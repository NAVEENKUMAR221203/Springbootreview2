package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.MedicineInfo;

@Repository
public interface MedicineInfoRepo extends JpaRepository<MedicineInfo,Integer> {

    
}