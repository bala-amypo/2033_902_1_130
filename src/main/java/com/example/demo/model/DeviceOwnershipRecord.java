package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "device_ownership",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "serialNumber")
        }
)
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String ownerEmail;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private LocalDate warrantyExpiration;

    @Column(nullable = false)
    private Boolean active;

    public DeviceOwnershipRecord() {
    }

    public DeviceOwnershipRecord(
            Long id,
            String serialNumber,
            String ownerName,
            String ownerEmail,
            LocalDate purchaseDate,
            LocalDate warrantyExpiration,
            Boolean active) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.purchaseDate = purchaseDate;
        this.warrantyExpiration = warrantyExpiration;
        this.active = active;
    }

    @PrePersist
    public void prePersist() {
        if (this.active == null) {
            this.active = true;
        }
    }


    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
