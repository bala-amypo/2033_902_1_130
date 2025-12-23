package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository repository;

    public FraudAlertServiceImpl(FraudAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        alert.setAlertDate(LocalDateTime.now());
        alert.setResolved(false);
        return repository.save(alert);
    }

    @Override
    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord alert = repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Fraud alert not found with id: " + id));

        alert.setResolved(true);
        return repository.save(alert);
    }

    @Override
    public FraudAlertRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Fraud alert not found with id: " + id));
    }

    @Override
    public List<FraudAlertRecord> getBySerialNumber(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<FraudAlertRecord> getByClaimId(Long claimId) {
        return repository.findByClaimId(claimId);
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}
