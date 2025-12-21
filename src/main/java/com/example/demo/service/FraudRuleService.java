package com.example.demo.service;
import java.util.List;
import com.example.demo.model.FraudRule;
public interface FraudRuleService{
    FraudRule createRule(FraudRule rule);
    FraudRule updateRule(Long id,FraudRule updatedRule);
    List<FraudRule>getActiveRules();
    List<FraudRule>getRuleByCode(String ruleCode);
    List<FraudRule>getAllRules();
}