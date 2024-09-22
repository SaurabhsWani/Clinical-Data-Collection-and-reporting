package com.saurbah.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurbah.clinicals.entities.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer>{

}
