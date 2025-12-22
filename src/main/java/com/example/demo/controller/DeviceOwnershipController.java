package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(
            DeviceOwnershipService service) {
        this.service = service;
    }

    // POST /api/devices
    @PostMapping
    public DeviceOwnershipRecord registerDevice(
            @RequestBody DeviceOwnershipRecord device) {
        return service.registerDevice(device);
    }

    // PUT /api/devices/{id}/status
    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateStatus(
            @PathVariable Long id,
            @RequestParam Boolean active) {
        return service.updateStatus(id, active);
    }

    // GET /api/devices/serial/{serialNumber}
    @GetMapping("/serial/{serialNumber}")
    public DeviceOwnershipRecord getBySerialNumber(
            @PathVariable String serialNumber) {
        return service.getBySerialNumber(serialNumber);
    }

    // GET /api/devices/{id}
    @GetMapping("/{id}")
    public DeviceOwnershipRecord getById(
            @PathVariable Long id) {
        return service.getById(id);
    }

    // GET /api/devices
    @GetMapping
    public List<DeviceOwnershipRecord> getAllDevices() {
        return service.getAllDevices();
    }
}
