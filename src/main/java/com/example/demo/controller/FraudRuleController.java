package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;

@RestController
@RequestMapping("/fraud-rules")
public class FraudRuleController {

    @Autowired
    private FraudRuleService service;

    // Create fraud rule
    @PostMapping
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    // Update fraud rule
    @PutMapping("/{id}")
    public FraudRule updateRule(@PathVariable Long id,
                                @RequestBody FraudRule updatedRule) {
        return service.updateRule(id, updatedRule);
    }

    // Get all active rules
    @GetMapping("/active")
    public List<FraudRule> getActiveRules() {
        return service.getActiveRules();
    }

    // Get rules by rule code
    @GetMapping("/code/{ruleCode}")
    public List<FraudRule> getRuleByCode(@PathVariable String ruleCode) {
        return service.getRuleByCode(ruleCode);
    }

    // Get all rules
    @GetMapping
    public List<FraudRule> getAllRules() {
        return service.getAllRules();
    }
}
