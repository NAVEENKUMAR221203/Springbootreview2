package com.examly.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Medicine;
import com.examly.springapp.services.MedicineService;

import java.util.List;





@RestController
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/medicine")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.saveMedicine(medicine);
    }

    @GetMapping("/medicines")
    public ResponseEntity<List<Medicine>> getListOfMedicines() {
        List<Medicine> medicines = medicineService.listofMedicines();
        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }
   
    @GetMapping("/medicines/{medicineId}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable int medicineId) {
        Medicine medicine = medicineService.getMedById(medicineId);
        if (medicine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }
    
    // @PutMapping("/medicines/{medicineId}/{medicine}")
    // public ResponseEntity updateMedicine(@PathVariable int medicineId, @PathVariable String medicine) {
    //     boolean updated = medicineService.updateMedicineBrandById(medicineId, medicine);
    //     if (updated) {
    //         return new ResponseEntity<>(medicine, HttpStatus.OK);
    //     }
    //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    
    @DeleteMapping("/medicines/{medicineId}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable int medicineId) {
        boolean deleted = medicineService.deleteMedicineById(medicineId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/medicines/sortBy/{field}")
    public ResponseEntity<List<Medicine>> sortMedicinesBy(@PathVariable String field) {
        List<Medicine> sortedMedicines = medicineService.sortMedicinesBy(field);
        if (sortedMedicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sortedMedicines, HttpStatus.OK);
    }
    
    // @PutMapping("/medicines/{medicineId}/{newBrand}")
    // public ResponseEntity<Void> updateMedicineBrand(@PathVariable int medicineId, @PathVariable String newBrand) {
    //     boolean updated = medicineService.updateMedicineBrandById(medicineId, newBrand);
    //     if (updated) {
    //         return new ResponseEntity<>(HttpStatus.OK);
    //     }
    //     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    // }
    @GetMapping("/api/medicine/{offset}/{pagesize}")
    public ResponseEntity<List<Medicine>> paging(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize)
    {
        List<Medicine> li=medicineService.pagemethod(offset,pagesize);
        if(li.size()==0)
        {
            return new ResponseEntity<>(null,HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(li,HttpStatus.OK);

    }
    
   
    
}
