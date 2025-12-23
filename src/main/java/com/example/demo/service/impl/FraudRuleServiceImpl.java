package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRule createRule(FraudRule rule) {
        return repository.save(rule);
    }

    @Override
    public FraudRule updateRule(Long id, FraudRule rule) {
        FraudRule existing = repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Rule not found: " + id));

        existing.setRuleCode(rule.getRuleCode());
        existing.setDescription(rule.getDescription());
        existing.setRuleType(rule.getRuleType());
        existing.setActive(rule.getActive());

        return repository.save(existing);
    }

    @Override
    public FraudRule getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Rule not found: " + id));
    }

    @Override
    public List<FraudRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public List<FraudRule> getActiveRules() {
        return repository.findAll()
                .stream()
                .filter(FraudRule::getActive)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
