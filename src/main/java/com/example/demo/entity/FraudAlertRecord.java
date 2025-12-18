package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class FraudAlertRecord{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long claimId;
    private String serialNumber;
    private String alertType;
    private String severity;
    private String 
}