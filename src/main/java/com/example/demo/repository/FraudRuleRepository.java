package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.FraudRule;
@Repository
public interface FraudRuleRepository extends JpaRepository<FraudRule,Integer>{

}