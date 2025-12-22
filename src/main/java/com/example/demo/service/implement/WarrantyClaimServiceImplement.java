package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRepository repository;

    public WarrantyClaimServiceImpl(WarrantyClaimRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        // 🔒 Serial number validation (stub – replace with real device check)
        if (claim.getSerialNumber() == null || claim.getSerialNumber().isBlank()) {
            throw new ValidationException("Invalid device serial number");
        }

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
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id: " + id));
    }

    @Override
    public List<WarrantyClaimRecord> getBySerialNumber(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return repository.findAll();
    }
}
