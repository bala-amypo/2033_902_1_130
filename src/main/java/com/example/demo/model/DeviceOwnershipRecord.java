package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
    name = "device_ownership_record",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "serial_number")
    }
)
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @Column(name = "warranty_expiration", nullable = false)
    private LocalDate warrantyExpiration;

    @Column(nullable = false)
    private Boolean active;

    // No-arg constructor
    public DeviceOwnershipRecord() {
    }

    // All-args constructor
    public DeviceOwnershipRecord(Long id, String serialNumber, String ownerName,
                                 String ownerEmail, LocalDate purchaseDate,
                                 LocalDate warrantyExpiration, Boolean active) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.purchaseDate = purchaseDate;
        this.warrantyExpiration = warrantyExpiration;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
