package com.covid.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class State implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int totalRecovered;
	private int totalDeceased;
	private int totalActive;
	private int totalConfirmed;
	private String state;
	private String statecode;
	private List<DistrictData> districtData;
	

	public String getStatecode() {
		return statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	public List<DistrictData> getDistrictData() {
		return districtData;
	}

	public void setDistrictData(List<DistrictData> districtData) {
		this.districtData = districtData;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(int totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public int getTotalDeceased() {
		return totalDeceased;
	}

	public void setTotalDeceased(int totalDeceased) {
		this.totalDeceased = totalDeceased;
	}

	public int getTotalActive() {
		return totalActive;
	}

	public void setTotalActive(int totalActive) {
		this.totalActive = totalActive;
	}

	public int getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(int totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}
	
}

