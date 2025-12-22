package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {

        // 🔒 ruleCode must be unique
        repository.findByRuleCode(rule.getRuleCode())
                .ifPresent(r -> {
                    throw new ValidationException(
                            "Fraud rule with code already exists: "
                                    + rule.getRuleCode());
                });

        if (rule.getActive() == null) {
            rule.setActive(true);
        }

        return repository.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule rule) {

        FraudRule existing = getById(id);

        existing.setDescription(rule.getDescription());
        existing.setRuleType(rule.getRuleType());
        existing.setActive(rule.getActive());

        return repository.save(existing);
    }

    @Override
    public FraudRule getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Fraud rule not found with id: " + id));
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }
}
