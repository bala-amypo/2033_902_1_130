package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        return repository.save(device);
    }

    @Override
    public DeviceOwnershipRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Device not found with id: " + id));
    }

    // ✅ THIS METHOD WAS MISSING (CAUSE OF ERROR)
    @Override
    public DeviceOwnershipRecord getBySerialNumber(String serialNumber) {
        return repository.findAll()
                .stream()
                .filter(d -> d.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Device not found with serial number: " + serialNumber));
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateStatus(Long id, Boolean active) {
        DeviceOwnershipRecord device = getById(id);
        device.setActive(active);
        return repository.save(device);
    }
}
