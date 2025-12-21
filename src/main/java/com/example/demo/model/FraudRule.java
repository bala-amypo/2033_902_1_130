package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "fraud_rules",
    uniqueConstraints = @UniqueConstraint(columnNames = "rule_code")
)
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_code", nullable = false, unique = true)
    private String ruleCode;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private String ruleType;

    @Column(nullable = false)
    private Boolean active;

    // 🔹 Constructors
    public FraudRule() {}

    public FraudRule(String ruleCode, String description, String ruleType, Boolean active) {
        this.ruleCode = ruleCode;
        this.description = description;
        this.ruleType = ruleType;
        this.active = active;
    }

    // 🔹 Getters & Setters
    public Long getId() {
        return id;
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

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
