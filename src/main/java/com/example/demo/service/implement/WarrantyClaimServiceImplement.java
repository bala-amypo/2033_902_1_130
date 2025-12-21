package com.example.demo.service.implement;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

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

        // Duplicate claim check (same serial + same issue)
        if (!repo.findBySerialNumber(claim.getSerialNumber()).isEmpty()) {
            throw new IllegalArgumentException("Warranty claim already submitted");
        }

        claim.setClaimDate(LocalDate.now());
        claim.setStatus("SUBMITTED");

        return repo.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {

        WarrantyClaimRecord claim = repo.findById(claimId)
                .orElseThrow(() ->
                        new NoSuchElementException("Warranty claim not found"));

        claim.setStatus(status);
        return repo.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getClaimById(Long id) {

        WarrantyClaimRecord claim = repo.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Warranty claim not found"));

        return List.of(claim);
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
