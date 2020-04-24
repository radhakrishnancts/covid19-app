package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.dto.StateWiseCases;
import com.covid.service.Covid19Service;

@RestController
public class Covid19Controller {

	@Autowired
	Covid19Service coronavirusTrackerApiService;

	@GetMapping("/covidTracker")
	public StateWiseCases getStateWiseCases(){
		return coronavirusTrackerApiService.getStateWiseCases();
	}
	
}
