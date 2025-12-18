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
    
}