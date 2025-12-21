package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.StolenDeviceReport;

public interface StolenDeviceReportRepository
        extends JpaRepository<StolenDeviceReport, Long> {

    List<StolenDeviceReport> findBySerialNumber(String serialNumber);
}
