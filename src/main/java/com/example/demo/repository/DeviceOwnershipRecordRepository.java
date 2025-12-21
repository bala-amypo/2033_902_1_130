package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.DeviceOwnershipRecord;
@Repository
public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord,Long>{
    List<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
    List<DeviceOwnershipRecord> findByNumber(Long id);
}