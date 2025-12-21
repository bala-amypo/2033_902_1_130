package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FraudRule;

@Repository
public interface FraudRuleRepository extends JpaRepository<FraudRule, Long> {

    // Fetch only active rules
    List<FraudRule> findByActiveTrue();

    // Fetch rules by rule code
    List<FraudRule> findByRuleCode(String ruleCode);
}
