package com.covid.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StateWiseCases
{
	private int totalRecovered;
	private int totalDeceased;
	private int totalActive;
	private int totalConfirmed;
	
	private List<State> states;
	

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
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
	