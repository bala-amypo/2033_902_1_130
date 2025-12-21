package com.example.demo.controller;
import java.util.List;
import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/devices")
public class FraudAlertController{

    private FraudAlertService service;

    @PostMapping
    public FraudAlertRecord createAlert(@RequestBody FraudAlertRecord alert) {
        return service.createRule(alert);
    }

    @PutMapping("/resolve/{id}")
    public FraudAlertRecord resolveAlert(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<FraudAlertRecord> getBySerial(@PathVariable String serialNumber) {
        return service.getAlertBySerial(serialNumber);
    }

    @GetMapping("/claim/{claimId}")
    public List<FraudAlertRecord> getByClaim(@PathVariable Long claimId) {
        return service.getAlertByClaim(claimId);
    }

    @GetMapping
    public List<FraudAlertRecord> getAllAlerts() {
        return service.getAllRules();
    }
}