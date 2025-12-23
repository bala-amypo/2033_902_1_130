package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository repository;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public StolenDeviceReport reportStolenDevice(StolenDeviceReport report) {
        report.setReportDate(LocalDateTime.now());
        return repository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getBySerialNumber(String serialNumber) {
        return repository.findAll()
                .stream()
                .filter(r -> r.getSerialNumber().equals(serialNumber))
                .toList();
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repository.findAll();
    }
}
