package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService deviceOwnershipService;

    public DeviceOwnershipController(DeviceOwnershipService deviceOwnershipService) {
        this.deviceOwnershipService = deviceOwnershipService;
    }

    @PostMapping("/POST")
    public DeviceOwnershipRecord registerDevice(
            @RequestBody DeviceOwnershipRecord device) {
        return deviceOwnershipService.registerDevice(device);
    }
    @GetMapping("/GET/serial/{serialNumber}")
    public List<DeviceOwnershipRecord> getBySerial(
            @PathVariable String serialNumber) {
        return deviceOwnershipService.getBySerial(serialNumber);
    }
    
    @GetMapping("/GET")
    public List<DeviceOwnershipRecord> getAllDevices() {
        return deviceOwnershipService.getAllDevices();
    }
    @PutMapping("/PUT/{id}/status")
    public DeviceOwnershipRecord updateDeviceStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return deviceOwnershipService.updateDeviceStatus(id, active);
    }
}