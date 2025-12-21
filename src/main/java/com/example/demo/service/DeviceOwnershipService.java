package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import java.util.List;

public interface DeviceOwnershipService {
    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);
    DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active);
    DeviceOwnershipRecord getDeviceById(Long id);
    DeviceOwnershipRecord getDeviceBySerialNumber(String serialNumber);
    List<DeviceOwnershipRecord> getAllDevices();
}
