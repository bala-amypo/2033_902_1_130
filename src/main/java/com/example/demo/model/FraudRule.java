package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "fraud_rules",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "ruleCode")
        }
)
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleCode;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String ruleType;

    @Column(nullable = false)
    private Boolean active;

    public FraudRule() {
    }

    public FraudRule(
            Long id,
            String ruleCode,
            String description,
            String ruleType,
            Boolean active) {
        this.id = id;
        this.ruleCode = ruleCode;
        this.description = description;
        this.ruleType = ruleType;
        this.active = active;
    }


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
