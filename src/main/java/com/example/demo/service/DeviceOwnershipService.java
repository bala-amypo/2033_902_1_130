package com.example.demo.service;
public interface DeviceOwnershipService{
    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);
    List<DeviceOwnershipRecord> getBySerial(String serialNumber)
}