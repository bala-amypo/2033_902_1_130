package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class FraudAlertRecord{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long claimId;
    private String serialNumber;
    private String alertType;
    private String severity;
    private String message;
    private LocalDateTime alertDate;
    private Boolean resolved;

    public int getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public int getClaimId(){
        return claimId;
    }
    public void setClaimId(Long claimId){
        this.claimId=claimId;
    }
    public String getSerialNumber(){
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber){
        this.serialNumber=serialNumber;
    }
    public String getAlertType(){
        return alertType;
    }
    
}