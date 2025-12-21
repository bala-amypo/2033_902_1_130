package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    // Submit a claim
    @PostMapping("/")
    public WarrantyClaimRecord submitClaim(@RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    // Update claim status
    @PutMapping("/{id}/status")
    public WarrantyClaimRecord updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateClaimStatus(id, status);
    }

    // Get claim by ID
    @GetMapping("/{id}")
    public WarrantyClaimRecord getClaimById(@PathVariable Long id) {
        return service.getClaimById(id);
    }

    // Get claims by serial number
    @GetMapping("/serial/{serialNumber}")
    public List<WarrantyClaimRecord> getClaimsBySerial(@PathVariable String serialNumber) {
        return service.getClaimsBySerial(serialNumber);
    }

    // Get all claims
    @GetMapping("/")
    public List<WarrantyClaimRecord> getAllClaims() {
        return service.getAllClaims();
    }
}
