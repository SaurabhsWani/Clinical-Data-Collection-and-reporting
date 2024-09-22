package com.saurbah.clinicals.contorller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurbah.clinicals.entities.Patient;
import com.saurbah.clinicals.repos.PatientRepository;

@RestController
@RequestMapping("/api")
public class PatuientContorller {

	@Autowired
	private PatientRepository patientRepository;

	@GetMapping(value = "/patients")
	public List<Patient> getPatient() {
		return patientRepository.findAll();
	}

	@GetMapping(value = "/patients/{id}")
	public Patient getSinglePatient(@PathVariable int id) {
		Optional<Patient> patientOptional = patientRepository.findById(id);
		if (patientOptional.isPresent()) {
			return patientOptional.get();
		}
		return new Patient();
	}

	@PostMapping(value = "/patients")
	public void addPatient(@RequestBody Patient patient) {
		patientRepository.save(patient);
	}
}
