package com.examly.springapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medicine {
    @Id
    private int medicineId;
    private String medicineName;


    @OneToOne( cascade = CascadeType.ALL)
    public MedicineInfo medicineInfo;


    

        
    
    
}
