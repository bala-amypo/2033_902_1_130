package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {

        if (repository.existsByRuleCode(rule.getRuleCode())) {
            throw new IllegalArgumentException(
                    "Fraud rule already exists: " + rule.getRuleCode());
        }

        return repository.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule rule) {

        FraudRule existing = repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Fraud rule not found with id: " + id));

        existing.setRuleCode(rule.getRuleCode());
        existing.setDescription(rule.getDescription());
        existing.setRuleType(rule.getRuleType());
        existing.setActive(rule.isActive());

        return repository.save(existing);
    }

    @Override
    public FraudRule getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Fraud rule not found with id: " + id));
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public void deleteRule(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(
                    "Fraud rule not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
