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
            StolenDeviceReportService service) {
        this.service = service;
    }

    // POST /api/stolen-devices
    @PostMapping
    public StolenDeviceReport reportStolenDevice(
            @RequestBody StolenDeviceReport report) {
        return service.reportStolenDevice(report);
    }

    // GET /api/stolen-devices/serial/{serialNumber}
    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getBySerialNumber(
            @PathVariable String serialNumber) {
        return service.getBySerialNumber(serialNumber);
    }

    // GET /api/stolen-devices/{id}
    @GetMapping("/{id}")
    public StolenDeviceReport getById(
            @PathVariable Long id) {
        return service.getById(id);
    }

    // GET /api/stolen-devices
    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return service.getAllReports();
    }
}
