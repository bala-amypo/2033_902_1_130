package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alerts")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long claimId;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String alertType;

    @Column(nullable = false)
    private String severity;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime alertDate;

    @Column(nullable = false)
    private Boolean resolved;

    public FraudAlertRecord() {
    }

    public FraudAlertRecord(
            Long id,
            Long claimId,
            String serialNumber,
            String alertType,
            String severity,
            String message,
            LocalDateTime alertDate,
            Boolean resolved) {
        this.id = id;
        this.claimId = claimId;
        this.serialNumber = serialNumber;
        this.alertType = alertType;
        this.severity = severity;
        this.message = message;
        this.alertDate = alertDate;
        this.resolved = resolved;
    }

    @PrePersist
    public void prePersist() {
        this.alertDate = LocalDateTime.now();
        if (this.resolved == null) {
            this.resolved = false;
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(LocalDateTime alertDate) {
        this.alertDate = alertDate;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
