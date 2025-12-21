package com.example.demo.service;
import java
public interface FraudAlertService{
    FraudAlertRecord createRule(FraudAlertRecord alert);
    FraudAlertRecord resolveAlert(Long id);
    List<FraudAlertRecord>getAlertBySerial(String ser)
}