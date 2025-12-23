package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(
            StolenDeviceService service) {
        this.service = service;
    }

    @PostMapping
    public StolenDeviceReport reportStolenDevice(
            @RequestBody StolenDeviceReport report) {
        return service.reportStolenDevice(report);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getBySerialNumber(
            @PathVariable String serialNumber) {
        return service.getBySerialNumber(serialNumber);
    }

    @GetMapping("/{id}")
    public StolenDeviceReport getById(
            @PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return service.getAllReports();
    }
}
