package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class StolenDeviceReport{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private String reportedBy;
    private LocalDateTime reportDate;
    private String details;

    public int getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getRuleCode(){
        return ruleCode;
    }
    public void setRuleCode(String ruleCode){
        this.ruleCode=ruleCode;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public 
}