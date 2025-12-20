package com.example.demo.service;
public interface DeviceOwnershipService{
    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);
    List<DeviceOwnershipRecord> getBySerial(String serialNumber);
    <ListDeviceOwnershipRecord> getAllDevices();
    DeviceOwnershipRecord updateDeviceStatus(Long id,boolean active);
}