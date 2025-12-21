package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;

@RestController
@RequestMapping("/api/warranty-claims")
public class WarrantyClaimController {

    @Autowired
    private WarrantyClaimService service;

    @PostMapping
    public WarrantyClaimRecord submitClaim(
            @RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    @PutMapping("/{id}/status")
    public WarrantyClaimRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateClaimStatus(id, status);
    }

    @GetMapping("/{id}")
    public List<WarrantyClaimRecord> getById(@PathVariable Long id) {
        return service.getClaimById(id);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<WarrantyClaimRecord> getBySerial(
            @PathVariable String serialNumber) {
        return service.getClaimsBySerial(serialNumber);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAllClaims() {
        return service.getAllClaims();
    }
}
