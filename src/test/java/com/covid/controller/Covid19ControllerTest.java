package com.covid.controller;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.covid.dto.StateWiseCases;
import com.covid.service.Covid19Service;

@RunWith(SpringRunner.class)
@WebMvcTest
public class Covid19ControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	Covid19Controller covid19Controller;
	
	@MockBean
	Covid19Service covid19Service;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(covid19Controller).build();
	}
	
	@Test
	public void getCovidCasesStatewise() throws Exception {
		when(covid19Service.getStateWiseCases()).thenReturn(new StateWiseCases());
		mockMvc.perform(get("/covidTracker")).andExpect(status().isOk()).andDo(print());
		verify(covid19Service, times(1)).getStateWiseCases();
	}
}
	