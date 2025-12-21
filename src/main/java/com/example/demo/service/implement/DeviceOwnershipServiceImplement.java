package com.example.demo.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;

@Service
public class DeviceOwnershipServiceImplement implements DeviceOwnershipService {

    @Autowired
    private DeviceOwnershipRecordRepository repo;

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        return repo.save(device);
    }

    @Override
    public List<DeviceOwnershipRecord

    @Override
    public List<DeviceOwnershipRecord> getBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord device = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));

        device.setActive(active);
        return repo.save(device);
    }
}
