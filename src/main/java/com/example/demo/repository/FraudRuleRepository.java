package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FraudRule;

public interface FraudRuleRepository extends JpaRepository<FraudRule, Long> {

    Optional<FraudRule> findByRuleCode(String ruleCode);

    List<FraudRule> findByActiveTrue();

    List<FraudRule> findByRuleCodeAndActiveTrue(String ruleCode);
}
