package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceRecord;
import com.example.demo.repository.StolenDeviceRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceRepository repository;

    public StolenDeviceServiceImpl(StolenDeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public StolenDeviceRecord reportStolen(StolenDeviceRecord record) {

        if (repository.existsBySerialNumber(record.getSerialNumber())) {
            throw new IllegalArgumentException(
                    "Device already reported stolen: " + record.getSerialNumber());
        }

        record.setReportDate(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public StolenDeviceRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Stolen device record not found with id: " + id));
    }

    @Override
    public List<StolenDeviceRecord> getAll() {
        return repository.findAll();
    }
}
