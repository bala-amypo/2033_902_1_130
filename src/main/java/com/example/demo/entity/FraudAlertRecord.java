package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class FraudAlertRecord{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruleCode;
    private String description;
    private String ruleType;
    private Boolean active;

    public Long getId(){
        return id;
    }
    public void 
}