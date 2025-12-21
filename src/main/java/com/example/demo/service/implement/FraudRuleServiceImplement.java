package com.example.demo.service.implement;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

@Service
public class FraudRuleServiceImplement implements FraudRuleService {

    @Autowired
    private FraudRuleRepository repo;

    @Override
    public FraudRule createRule(FraudRule rule) {
        if (repo.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new IllegalArgumentException("Rule code already exists");
        }
        rule.setActive(true);
        return repo.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule updatedRule) {
        FraudRule existing = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Fraud rule not found"));

        existing.setDescription(updatedRule.getDescription());
        existing.setRuleType(updatedRule.getRuleType());
        existing.setActive(updatedRule.getActive());

        return repo.save(existing);
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public List<FraudRule> getRuleByCode(String ruleCode) {
        return repo.findByRuleCodeAndActiveTrue(ruleCode);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repo.findAll();
    }
}
