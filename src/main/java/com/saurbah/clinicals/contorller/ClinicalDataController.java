package com.saurbah.clinicals.contorller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurbah.clinicals.dto.ClinicalDataReq;
import com.saurbah.clinicals.entities.ClinicalData;
import com.saurbah.clinicals.entities.Patient;
import com.saurbah.clinicals.repos.ClinicalDataRepository;
import com.saurbah.clinicals.repos.PatientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {

	@Autowired
	private ClinicalDataRepository clinicalDataRepository;

	@Autowired
	private PatientRepository patientRepository;

	@PostMapping(value = "/clinicals")
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataReq data) {
		Optional<Patient> patientOptional = patientRepository.findById(data.getPatientId());
		if (patientOptional.isPresent()) {
			Patient patient = patientOptional.get();
			ClinicalData clinicalData = new ClinicalData();
			clinicalData.setComponentName(data.getComponentName());
			clinicalData.setComponentValue(data.getComponentValue());
			clinicalData.setPatient(patient);
			return clinicalDataRepository.save(clinicalData);
		}
		return new ClinicalData();
	}
}
