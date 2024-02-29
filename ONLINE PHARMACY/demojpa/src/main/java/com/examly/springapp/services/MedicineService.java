package com.examly.springapp.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examly.springapp.model.Medicine;
import com.examly.springapp.repository.MedicineRepo;

@Service
@Transactional
public class MedicineService {
    private final MedicineRepo medicineRepo;

    public MedicineService(MedicineRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }

    public Medicine saveMedicine(Medicine medicine) {
       return medicineRepo.save(medicine);
    }
    
    public List<Medicine> listofMedicines() {
        return medicineRepo.findAll();
    }

    public Medicine getMedById(int id) {
        return medicineRepo.findById(id).orElse(null);
    }

    // public boolean updateMedicineBrandById(int medicineId, String newBrand) {
    //     Medicine existingMedicine = getMedById(medicineId);
    //     if (existingMedicine != null) {
    //         try {
    //             medicineRepo.updateMedicineBrandById(newBrand, medicineId);
    //             return true;
    //         } catch (Exception e) {
    //             e.printStackTrace(); // Handle or log the exception properly
    //         }
    //     }
    //     return false;
    // }

    public boolean deleteMedicineById(int medicineId) {
        if (getMedById(medicineId) != null) {
            try {
                medicineRepo.deleteById(medicineId);
                return true;
            } catch (Exception e) {
                e.printStackTrace(); // Handle or log the exception properly
            }
        }
        return false;
    }
    
    public List<Medicine> sortMedicinesBy(String field) {
        return medicineRepo.findAll(Sort.by(field));
    }
    public List<Medicine> pagemethod(int offset,int pagesize)
    {
        return medicineRepo.findAll(PageRequest.of(offset, pagesize)).getContent();
    }
}
