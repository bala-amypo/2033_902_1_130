package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.FraudAlertRecord;
@Repository
public interface FraudAlertRecordRepository extends JpaRepository<FraudAlertRecord,Integer>{

}