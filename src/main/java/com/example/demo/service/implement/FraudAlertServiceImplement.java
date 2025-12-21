package com.example.demo.service.implement;
import com.example.demo.service.FraudAlertService;
public class FraudAlertServiceImplement implements FraudAlertService{
     @Autowired
    private FraudAlertRecordRepository repo;

    // 1. Create a new fraud alert rule
    @Override
    public FraudAlertRecord createRule(FraudAlertRecord alert) {
        alert.setResolved(false); // new alert is unresolved
        return repo.save(alert);
    }

    // 2. Resolve a fraud alert using ID
    @Override
    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord alert = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));

        alert.setResolved(true);  // mark as resolved
        return repo.save(alert);
    }

    // 3. Get alerts by device serial number
    @Override
    public List<FraudAlertRecord> getAlertBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }

    // 4. Get alerts by claim ID
    @Override
    public List<FraudAlertRecord> getAlertByClaim(Long claimId) {
        return repo.findByClaimId(claimId);
    }

    // 5. Get all fraud alert rules
    @Override
    public List<FraudAlertRecord> getAllRules() {
        return repo.findAll();
    }
}