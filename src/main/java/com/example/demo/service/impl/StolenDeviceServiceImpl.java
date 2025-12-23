package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StolenDeviceServiceImpl
        implements StolenDeviceService {

    private final StolenDeviceReportRepository repository;

    public StolenDeviceServiceImpl(
            StolenDeviceReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public StolenDeviceReport reportStolenDevice(
            StolenDeviceReport report) {

        if (report.getSerialNumber() == null
                || report.getSerialNumber().isBlank()) {
            throw new ValidationException("Invalid device serial number");
        }

        return repository.save(report);
    }

    @Override
    public StolenDeviceReport getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Stolen report not found with id: " + id));
    }

    @Override
    public List<StolenDeviceReport> getBySerialNumber(
            String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repository.findAll();
    }
}
