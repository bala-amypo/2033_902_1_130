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

    // POST /api/claims
    @PostMapping
    public WarrantyClaimRecord submitClaim(@RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    // PUT /api/claims/{id}/status
    @PutMapping("/{id}/status")
    public WarrantyClaimRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    // GET /api/claims/serial/{serialNumber}
    @GetMapping("/serial/{serialNumber}")
    public List<WarrantyClaimRecord> getBySerial(@PathVariable String serialNumber) {
        return service.getBySerialNumber(serialNumber);
    }

    // GET /api/claims/{id}
    @GetMapping("/{id}")
    public WarrantyClaimRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET /api/claims
    @GetMapping
    public List<WarrantyClaimRecord> getAllClaims() {
        return service.getAllClaims();
    }
}
