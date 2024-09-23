package com.saurbah.clinicals.dto;

public class ClinicalDataReq {

	private String componentName;
	private String componentValue;
	private int patientId;

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "ClinicalDataReq [componentName=" + componentName + ", componentValue=" + componentValue + ", patientId="
				+ patientId + "]";
	}
}
