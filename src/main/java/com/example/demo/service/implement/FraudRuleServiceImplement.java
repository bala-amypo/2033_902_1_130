package com.example.demo.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

@Service
public class FraudRuleServiceImplement implements FraudRuleService {

    @Autowired
    private FraudRuleRepository repo;

    // Create new fraud rule
    @Override
    public FraudRule createRule(FraudRule rule) {
        rule.setActive(true); // new rule is active by default
        return repo.save(rule);
    }

    // Update existing fraud rule
    @Override
    public FraudRule updateRule(Long id, FraudRule updatedRule) {
        FraudRule existingRule = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Fraud rule not found"));

        existingRule.setRuleCode(updatedRule.getRuleCode());
        existingRule.setDescription(updatedRule.getDescription());
        existingRule.setActive(updatedRule.isActive());

        return repo.save(existingRule);
    }

    // Fetch all active rules
    @Override
    public List<FraudRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    // Fetch rules by rule code
    @Override
    public List<FraudRule> getRuleByCode(String ruleCode) {
        return repo.findByRuleCode(ruleCode);
    }

    // Fetch all rules
    @Override
    public List<FraudRule> getAllRules() {
        return repo.findAll();
    }
}
