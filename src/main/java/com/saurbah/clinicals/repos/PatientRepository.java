package com.saurbah.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurbah.clinicals.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
