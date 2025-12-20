package com.example.demo.service;
import java.util.List;
import com.example.demo.model.DeviceOwnershipRecord;
public interface DeviceOwnershipService{
    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);
    List<DeviceOwnershipRecord> getBySerial(String serialNumber);
    <ListDeviceOwnershipRecord> getAllDevices();
    DeviceOwnershipRecord updateDeviceStatus(Long id,boolean active);
}