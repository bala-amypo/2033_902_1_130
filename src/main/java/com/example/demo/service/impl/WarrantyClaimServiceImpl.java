package com.example.demo.service.impl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository repository;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        claim.setSubmittedAt(LocalDateTime.now());
        claim.setStatus("SUBMITTED");
        return repository.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateStatus(Long id, String status) {
        WarrantyClaimRecord claim = getById(id);
        claim.setStatus(status);
        return repository.save(claim);
    }

    @Override
    public WarrantyClaimRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Claim not found with id: " + id));
    }

    @Override
    public List<WarrantyClaimRecord> getBySerialNumber(String serialNumber) {
        List<WarrantyClaimRecord> claims = repository.findAll()
                .stream()
                .filter(c -> c.getSerialNumber().equals(serialNumber))
                .toList();

        if (claims.isEmpty()) {
            throw new NoSuchElementException(
                    "No claims found for serial number: " + serialNumber);
        }

        return claims;
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return repository.findAll();
    }
}
