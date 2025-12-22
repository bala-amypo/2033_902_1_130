package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;

import java.util.List;

public interface StolenDeviceService {

    StolenDeviceReport reportStolenDevice(StolenDeviceReport report);

    StolenDeviceReport getById(Long id);

    List<StolenDeviceReport> getBySerialNumber(String serialNumber);

    List<StolenDeviceReport> getAllReports();
}
