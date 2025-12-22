package com.example.demo.service;

import com.example.demo.model.FraudAlertRecord;

import java.util.List;

public interface FraudAlertService {

    FraudAlertRecord createAlert(FraudAlertRecord alert);

    FraudAlertRecord resolveAlert(Long id);

    FraudAlertRecord getById(Long id);

    List<FraudAlertRecord> getBySerialNumber(String serialNumber);

    List<FraudAlertRecord> getByClaimId(Long claimId);

    List<FraudAlertRecord> getAllAlerts();
}
