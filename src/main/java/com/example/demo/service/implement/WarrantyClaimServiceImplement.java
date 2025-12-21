package com.example.demo.service.implement;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;

@Service
public class WarrantyClaimServiceImplement implements WarrantyClaimService {

    @Autowired
    private WarrantyClaimRecordRepository repo;

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        claim.setSubmittedAt(LocalDateTime.now());   // ✅ CORRECT
        claim.setStatus("SUBMITTED");
        return repo.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {
        WarrantyClaimRecord claim = repo.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        claim.setStatus(status);
        return repo.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getClaimById(Long id) {
        return repo.findById(id).stream().toList();
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return repo.findAll();
    }
}
