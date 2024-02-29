package com.examly.springapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.MedicineInfo;
import com.examly.springapp.repository.MedicineInfoRepo;

@Service
public class MedicineInfoService {
    private MedicineInfoRepo medicineInfoRepo;

    public MedicineInfoService(MedicineInfoRepo medicineInfoRepo) {
        this.medicineInfoRepo = medicineInfoRepo;
    }
    
    public MedicineInfo medicalInfo(MedicineInfo medicineInfo)
    {
        
           return  medicineInfoRepo.save(medicineInfo);
       
    }
    public List<MedicineInfo> getin()
    {
        return medicineInfoRepo.findAll();
    }
}
