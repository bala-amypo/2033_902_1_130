package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    @Autowired
    private StolenDeviceService service;

    @PostMapping
    public StolenDeviceReport reportStolen(
            @RequestBody StolenDeviceReport report) {
        return service.reportStolen(report);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getBySerial(
            @PathVariable String serialNumber) {
        return service.getReportsBySerial(serialNumber);
    }

    @GetMapping("/{id}")
    public List<StolenDeviceReport> getById(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return service.getAllReports();
    }
}
