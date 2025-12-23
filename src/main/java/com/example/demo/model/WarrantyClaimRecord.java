package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claims")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String claimantName;

    @Column(nullable = false)
    private String claimantEmail;

    @Column(nullable = false)
    private String claimReason;

    @Column(nullable = false)
    private String status; // PENDING / APPROVED / REJECTED / FLAGGED

    @Column(nullable = false)
    private LocalDateTime submittedAt;

    public WarrantyClaimRecord() {
    }

    public WarrantyClaimRecord(
            Long id,
            String serialNumber,
            String claimantName,
            String claimantEmail,
            String claimReason,
            String status,
            LocalDateTime submittedAt) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.claimantName = claimantName;
        this.claimantEmail = claimantEmail;
        this.claimReason = claimReason;
        this.status = status;
        this.submittedAt = submittedAt;
    }

    @PrePersist
    public void prePersist() {
        this.submittedAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "PENDING";
        }
    }


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

    public String getClaimantName() {
        return claimantName;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }

    public String getClaimantEmail() {
        return claimantEmail;
    }

    public void setClaimantEmail(String claimantEmail) {
        this.claimantEmail = claimantEmail;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
