package com.covid.dto;

import java.io.Serializable;

public class DistrictData implements Serializable
{
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String district;
	    private int recovered;
	    private int deceased;
	    private int active;
	    private int confirmed;
	    private Delta delta;
	    
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public int getRecovered() {
			return recovered;
		}
		public void setRecovered(int recovered) {
			this.recovered = recovered;
		}
		public int getDeceased() {
			return deceased;
		}
		public void setDeceased(int deceased) {
			this.deceased = deceased;
		}
		public Delta getDelta() {
			return delta;
		}
		public void setDelta(Delta delta) {
			this.delta = delta;
		}
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}
		public int getConfirmed() {
			return confirmed;
		}
		public void setConfirmed(int confirmed) {
			this.confirmed = confirmed;
		}

}