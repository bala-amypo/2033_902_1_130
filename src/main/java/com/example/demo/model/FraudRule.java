package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_rules")
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_code", nullable = false, unique = true)
    private String ruleCode;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private boolean active;

    // 🔹 Default constructor (required by JPA)
    public FraudRule() {
    }

    // 🔹 Parameterized constructor (optional)
    public FraudRule(String ruleCode, String description, boolean active) {
        this.ruleCode = ruleCode;
        this.description = description;
        this.active = active;
    }

    // 🔹 Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ✅ Use getActive() to avoid compiler issues
    public boolean getActive() {
        return active;
    }

    // Optional (safe to include)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
