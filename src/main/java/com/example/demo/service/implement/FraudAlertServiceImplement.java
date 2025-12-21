@Service
public class FraudAlertServiceImplement implements FraudAlertService {

    @Autowired
    private FraudAlertRecordRepository repo;

    // 1. Create a new fraud alert rule
    @Override
    public FraudAlertRecord createRule(FraudAlertRecord alert) {
        alert.setResolved(false); // new alert is unresolved
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
