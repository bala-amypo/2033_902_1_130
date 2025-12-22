package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    // POST /api/fraud-rules
    @PostMapping
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    // PUT /api/fraud-rules/{id}
    @PutMapping("/{id}")
    public FraudRule updateRule(
            @PathVariable Long id,
            @RequestBody FraudRule rule) {
        return service.updateRule(id, rule);
    }

    // GET /api/fraud-rules/active
    @GetMapping("/active")
    public List<FraudRule> getActiveRules() {
        return service.getActiveRules();
    }

    // GET /api/fraud-rules/{id}
    @GetMapping("/{id}")
    public FraudRule getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET /api/fraud-rules
    @GetMapping
    public List<FraudRule> getAllRules() {
        return service.getAllRules();
    }
}
