package com.example.demo.service.implement;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;

@Service
public class StolenDeviceServiceImplement implements StolenDeviceService {

    @Autowired
    private StolenDeviceReportRepository repo;

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {

        // Duplicate stolen report check
        if (!repo.findBySerialNumber(report.getSerialNumber()).isEmpty()) {
            throw new IllegalArgumentException("Stolen device already reported");
        }

        report.setReportedDate(LocalDate.now());
        report.setRecovered(false);

        return repo.save(report);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber);
    }

    @Override
    public List<StolenDeviceReport> getReportById(Long id) {

        StolenDeviceReport report = repo.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Stolen report not found"));

        return List.of(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return repo.findAll();
    }
}
