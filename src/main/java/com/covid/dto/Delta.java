package com.covid.dto;

import java.io.Serializable;

public class Delta  implements Serializable{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private int recovered;

	    private int deceased;

	    private int confirmed;

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

		public int getConfirmed() {
			return confirmed;
		}

		public void setConfirmed(int confirmed) {
			this.confirmed = confirmed;
		}
	}


