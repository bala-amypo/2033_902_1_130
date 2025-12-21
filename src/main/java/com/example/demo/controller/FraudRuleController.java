package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    @Autowired
    private FraudRuleService service;

    @PostMapping
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public FraudRule updateRule(@PathVariable Long id, @RequestBody FraudRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<FraudRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/code/{ruleCode}")
    public List<FraudRule> getRuleByCode(@PathVariable String ruleCode) {
        return service.getRuleByCode(ruleCode);
    }

    @GetMapping
    public List<FraudRule> getAllRules() {
        return service.getAllRules();
    }
}
