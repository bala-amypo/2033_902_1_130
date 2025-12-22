package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceOwnershipServiceImpl
        implements DeviceOwnershipService {

    private final DeviceOwnershipRepository repository;

    public DeviceOwnershipServiceImpl(
            DeviceOwnershipRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(
            DeviceOwnershipRecord device) {

        if (repository.existsBySerialNumber(device.getSerialNumber())) {
            throw new ValidationException(
                    "Device already registered with serial: "
                            + device.getSerialNumber());
        }

        return repository.save(device);
    }

    @Override
    public DeviceOwnershipRecord updateStatus(Long id, Boolean active) {

        DeviceOwnershipRecord device = getById(id);
        device.setActive(active);
        return repository.save(device);
    }

    @Override
    public DeviceOwnershipRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Device not found with id: " + id));
    }

    @Override
    public DeviceOwnershipRecord getBySerialNumber(
            String serialNumber) {
        return repository.findBySerialNumber(serialNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Device not found with serial: "
                                        + serialNumber));
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }
}
