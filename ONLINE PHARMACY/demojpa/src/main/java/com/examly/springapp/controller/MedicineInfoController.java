package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.MedicineInfo;
import com.examly.springapp.services.MedicineInfoService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class MedicineInfoController {
    private MedicineInfoService medicineInfoService;

    public MedicineInfoController(MedicineInfoService medicineInfoService) {
        this.medicineInfoService = medicineInfoService;
    }
    @PostMapping("/medicineinfo")
    public MedicineInfo getInfo(@RequestBody MedicineInfo medicineInfo)
    {
       return medicineInfoService.medicalInfo(medicineInfo);
       
    }
    @GetMapping("/medicineinfos")
    public ResponseEntity<List<MedicineInfo>> gEntity()
    {
        List<MedicineInfo> list=medicineInfoService.getin();
        if(list.size()==0)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }
    
   
    
    
}
