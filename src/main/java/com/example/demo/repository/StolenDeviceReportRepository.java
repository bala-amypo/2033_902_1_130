package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.StolenDeviceReport;
@Repository
public interface StolenDeviceReportRepository extends JpaRepository<StolenDeviceReport,Integer>{

}