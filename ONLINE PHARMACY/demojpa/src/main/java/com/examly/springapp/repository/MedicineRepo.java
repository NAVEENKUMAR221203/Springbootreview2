package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Medicine;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer> {

    // @Modifying
    // @Query("UPDATE Medicine m SET m.medicineBrand = :medicineBrand WHERE m.medicineId = :medicineId")
    // void updateMedicineBrandById(String medicineBrand, int medicineId);
    
}
