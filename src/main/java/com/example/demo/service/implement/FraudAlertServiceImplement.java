package com.example.demo.service.implement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
public class FraudAlertServiceImplement implements FraudAlertService{
     @Autowired
    private FraudAlertRecordRepository repo;

    @Override
    public FraudAlertRecord createRule(FraudAlertRecord alert) {
        alert.setResolved(false); 
        return repo.save(alert);
    }

    @Override
    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord alert = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));

        alert.setResolved(true);  
        return repo.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAlertBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }
    @Override
    public List<FraudAlertRecord> getAlertByClaim(Long claimId) {
        return repo.findByClaimId(claimId);
    }

    @Override
    public List<FraudAlertRecord> getAllRules() {
        return repo.findAll();
    }
}