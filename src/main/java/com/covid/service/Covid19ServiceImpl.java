package com.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid.dto.DistrictData;
import com.covid.dto.State;
import com.covid.dto.StateWiseCases;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Service
public class Covid19ServiceImpl implements Covid19Service {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public StateWiseCases getStateWiseCases() {

		StateWiseCases stateWiseCases = new StateWiseCases();
		ResponseEntity<String> response = restTemplate
				.getForEntity("https://api.covid19india.org/v2/state_district_wise.json", String.class);
		List<State> stateList = null;
		if (response != null) {
			String str = null;
			try {
				
				TypeFactory typeFactory = objectMapper.getTypeFactory();
		        CollectionType collectionType = typeFactory.constructCollectionType(
		                                            List.class, State.class);
		        stateList = objectMapper.readValue(response.getBody(), collectionType);
		        
		        
			} catch (JsonProcessingException e) {
				System.err.println(str + "responseData" + stateWiseCases);
				System.err.println("error:::"+e);
			} catch (Exception e) {
				System.err.println(str + "responseData" + stateWiseCases);
			}
		}

		return buildTotals(stateList);
	}
	
	private StateWiseCases  buildTotals(List<State> stateList) {
		StateWiseCases stateWise = new StateWiseCases();
		int natRecovered = 0;
	    int natDeceased = 0;
	    int natActive = 0;
	    int natConfirmed = 0;
	    
	    int stateRecovered;
	    int stateDeceased;
	    int stateActive;
	    int stateConfirmed;
	    
	    for(State state:stateList) {
	    	stateRecovered = 0;
	    	stateDeceased = 0;
	    	stateActive = 0;
	    	stateConfirmed = 0;
	    	for(DistrictData dist:state.getDistrictData()) {
		    	stateRecovered = stateRecovered + dist.getRecovered();
		    	stateDeceased = stateDeceased + dist.getDeceased();
		    	stateActive = stateActive + dist.getActive();
		    	stateConfirmed = stateConfirmed + dist.getConfirmed();
		    	
		    	natRecovered = natRecovered + dist.getRecovered();
		    	natDeceased = natDeceased + dist.getDeceased();
		    	natActive = natActive + dist.getActive();
		    	natConfirmed = natConfirmed + dist.getConfirmed();
	    	}
	    	
	    	state.setTotalActive(stateActive);
	    	state.setTotalRecovered(stateRecovered);
	    	state.setTotalConfirmed(stateConfirmed);
	    	state.setTotalDeceased(stateDeceased);
	    }
	    stateWise.setTotalActive(natActive);
	    stateWise.setTotalRecovered(natRecovered);
	    stateWise.setTotalConfirmed(natConfirmed);
	    stateWise.setTotalDeceased(natDeceased);
	    stateWise.setStates(stateList);
	    return stateWise;
		
	}
}
