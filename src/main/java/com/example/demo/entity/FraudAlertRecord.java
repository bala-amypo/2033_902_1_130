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

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getClaimId(){
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
    public void setAlertType(String alertTpye){
        this.alertType=alertTpye;
    }
    public String getSeverity(){
        return severity;
    }
    public void setSeverity(String severity){
        this.severity=severity;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public LocalDateTime getAlertDate(){
        return alertDate;
    }
    public void setAlertDate(LocalDateTime alertDate){
        this.alertDate=alertDate;
    }
    public Boolean getResolved(){
        return resolved;
    }
    public void setResolved(Boolean resolved){
        this.resolved=resolved;
    }

    public FraudAlertRecord(Long id,Long claimId,String serialNumber,String alertType,String severity,String message,LocalDateType alertDate,Boolean resolved){
        this.id=id;
        this.claimId=claimId;
        this.serialNumber=serialNumber;
        this.alertType=alertType;
        this.severity=severity;
        this.message=message;
        this.alertDate=alertDate;
        this.resolved=resolved;
    }
    public FraudAlertRecord(){
        
    }
}