package com.example.demo.service;
import java.util.List;
import com.example.demo.model.FraudAlertRecord;
public interface FraudAlertService{
    FraudAlertRecord createRule(FraudAlertRecord alert);
    FraudAlertRecord resolveAlert(Long id);
    List<FraudAlertRecord>getAlertBySerial(String serialNumber);
    List<FraudAlertRecord>getAlertByClaim(Long claimId);
    List<FraudAlertRecord>getAllRules();
}