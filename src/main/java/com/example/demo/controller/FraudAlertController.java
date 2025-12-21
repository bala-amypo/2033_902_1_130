package com.example.demo.controller;
import java.util.List;
import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class FraudAlertController{
    @Autowired
    private FraudAlertService service;

    // 1. Create fraud alert
    @PostMapping
    public FraudAlertRecord createAlert(@RequestBody FraudAlertRecord alert) {
        return service.createRule(alert);
    }

    // 2. Resolve fraud alert
    @PutMapping("/resolve/{id}")
    public FraudAlertRecord resolveAlert(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

    // 3. Get alerts by serial number
    @GetMapping("/serial/{serialNumber}")
    public List<FraudAlertRecord> getBySerial(@PathVariable String serialNumber) {
        return service.getAlertBySerial(serialNumber);
    }

    // 4. Get alerts by claim ID
    @GetMapping("/claim/{claimId}")
    public List<FraudAlertRecord> getByClaim(@PathVariable Long claimId) {
        return service.getAlertByClaim(claimId);
    }

    // 5. Get all fraud alerts
    @GetMapping
    public List<FraudAlertRecord> getAllAlerts() {
        return service.getAllRules();
    }
}