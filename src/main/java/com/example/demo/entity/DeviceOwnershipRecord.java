package com.example.demo.entity;

import java.time.LocalDate;

public class DeviceOwnershipRecord {
    private Long id;
    private String serialNumber;
    private String ownerName;
    private String ownerEmail;
    private LocalDate purchaseDate;
    private LocalDate warrantyExpiration;
    

    public int getId(){
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
    public String getOwnerName(){
        return ownerName;
    }
    public void setOwnerName(String ownerName){
        this.ownerName=ownerName;
    }
    public LocalDate getPurchaseDate(){
        return purchaseDate;
    }
    public void setPurchaseDate(LocalDate purchaseDate){
        this.purchaseDate=purchaseDate;
    }
    public LocalDate getWarrantyExpiration(){
        return warrantyExpiration;
    }
    public void setWarrantyExpiration(LocalDate warrantyExpiration){
        this.
    }
}