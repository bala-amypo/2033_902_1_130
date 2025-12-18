package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class StolenDeviceReport{
    private Long id;
    private String serialNumber;
    private String reportedBy;
    private LocalDateTime reportDate;
    private String details;
}