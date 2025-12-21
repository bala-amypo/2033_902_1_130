package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.repository.WarrantyClaimRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRepository claimRepository;
    private final DeviceOwnershipRepository deviceRepository;

    public WarrantyClaimServiceImpl(WarrantyClaimRepository claimRepository, DeviceOwnershipRepository deviceRepository) {
        this.claimRepository = claimRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {
        // Check that serialNumber exists in devices
        DeviceOwnershipRecord device = deviceRepository.findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new IllegalArgumentException("Device with serial number not found"));

        return claimRepository.save(claim);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        WarrantyClaimRecord claim = claimRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Claim not found with id: " + id));
        claim.setStatus(status);
        return claimRepository.save(claim);
    }

    @Override
    public WarrantyClaimRecord getClaimById(Long id) {
        return claimRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Claim not found with id: " + id));
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepository.findAll();
    }
}
