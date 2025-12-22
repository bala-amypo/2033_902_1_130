package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;

import java.util.List;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);

    DeviceOwnershipRecord updateStatus(Long id, Boolean active);

    DeviceOwnershipRecord getById(Long id);

    DeviceOwnershipRecord getBySerialNumber(String serialNumber);

    List<DeviceOwnershipRecord> getAllDevices();
}
