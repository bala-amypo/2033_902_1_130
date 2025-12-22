package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String reportedBy;

    @Column(nullable = false)
    private LocalDateTime reportDate;

    @Column(nullable = false)
    private String details;

    // 🔹 No-args constructor (JPA requirement)
    public StolenDeviceReport() {
    }

    // 🔹 All-args constructor
    public StolenDeviceReport(
            Long id,
            String serialNumber,
            String reportedBy,
            LocalDateTime reportDate,
            String details) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.reportedBy = reportedBy;
        this.reportDate = reportDate;
        this.details = details;
    }

    // 🔹 Auto-generate reportDate
    @PrePersist
    public void prePersist() {
        this.reportDate = LocalDateTime.now();
    }

    // 🔹 Getters and Setters

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

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
