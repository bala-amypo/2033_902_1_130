package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository repository;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport record) {

        if (repository.existsBySerialNumber(record.getSerialNumber())) {
            throw new IllegalArgumentException(
                    "Device already reported stolen: " + record.getSerialNumber());
        }

        record.setReportDate(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public StolenDeviceReport getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Stolen device record not found with id: " + id));
    }

    @Override
    public List<StolenDeviceReport> getAll() {
        return repository.findAll();
    }
}
