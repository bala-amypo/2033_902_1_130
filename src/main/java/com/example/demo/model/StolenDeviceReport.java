package com.example.demo.model;
import java.time.*;
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

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getSerialNumber(){
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber){
        this.serialNumber=serialNumber;
    }
    public String getReportedBy(){
        return reportedBy;
    }
    public void setReportedBy(String reportedBy){
        this.reportedBy=reportedBy;
    }
    public LocalDateTime getReportDate(){
        return reportDate;
    }
    public void setReportDate(LocalDateTime reportDate){
        this.reportDate=reportDate;
    }
    public String getDetails(){
        return details;
    }
    public void setDetails(String details){
        this.details=details;
    }

    public StolenDeviceReport(Long id,String serialNumber,String reportedBy,LocalDateTime reportDate,String details){
        this.id=id;
        this.serialNumber=serialNumber;
        this.reportedBy=reportedBy;
        this.reportDate=reportDate;
        this.details=details;
    }

    public StolenDeviceReport(){
        
    }
}