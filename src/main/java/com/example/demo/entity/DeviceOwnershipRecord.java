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
}