package com.saurbah.clinicals.contorller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurbah.clinicals.entities.ClinicalData;
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
	public Patient addPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}

	@GetMapping("/patients/analyze/{id}")
	public Patient analyze(@PathVariable int id) {
		Optional<Patient> patientOptional = patientRepository.findById(id);
		if (patientOptional.isPresent()) {
			Map<String, String> filter = new HashMap<String, String>();
			Patient patient = patientOptional.get();
			List<ClinicalData> clinicalData = patient.getClinicalData();
			List<ClinicalData> duplicateClinicalData = new ArrayList<ClinicalData>(clinicalData);
			for (ClinicalData data : duplicateClinicalData) {
				if (filter.containsKey(data.getComponentName())) {
					clinicalData.remove(data);
					continue;
				} else {
					filter.put(data.getComponentName(), null);
				}
				if (data.getComponentName().equals("hw")) {
					String[] hw = data.getComponentValue().split("/");
					float heightInMeters = Float.parseFloat(hw[0]) * 0.4536f;
					float bmi = Float.parseFloat(hw[1]) / (heightInMeters * heightInMeters);
					ClinicalData bmiData = new ClinicalData();
					bmiData.setComponentName("bmi");
					bmiData.setComponentValue(Float.toString(bmi));
					clinicalData.add(bmiData);
				}
			}
			filter.clear();
			return patient;
		}
		return new Patient();
	}
}
