package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class MedicineInfo {
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String medicineFor;
    private String medicineBrand;
    private String manufacturedIn;
    private Double medicinePrice;
    private String expiryDate;
    
}
