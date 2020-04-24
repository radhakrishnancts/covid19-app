package com.covid.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.covid.dto.State;
import com.covid.dto.StateWiseCases;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest
public class Covid19ServiceTest {

	@InjectMocks
	Covid19ServiceImpl covid19ServiceImpl;

	@Mock
	RestTemplate restTemplate;

	@Mock
	ObjectMapper objectMapper;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCovidCases() throws IOException {
		// ARRANGE
		String stateData = "[{\"state\":\"Andaman and Nicobar Islands\",\"statecode\":\"AN\",\"districtData\":[{\"district\":\"North and Middle Andaman\",\"notes\":\"\",\"active\":0,\"confirmed\":1,\"deceased\":0,\"recovered\":1,\"delta\":{\"confirmed\":0,\"deceased\":0,\"recovered\":0}}]}]";
		Gson gson = new Gson();
		State state = gson.fromJson(
				"{\"state\":\"Andaman and Nicobar Islands\",\"statecode\":\"AN\",\"districtData\":[{\"district\":\"North and Middle Andaman\",\"notes\":\"\",\"active\":0,\"confirmed\":1,\"deceased\":0,\"recovered\":1,\"delta\":{\"confirmed\":0,\"deceased\":0,\"recovered\":0}}]}",
				State.class);
		List<State> response = new ArrayList<>();
		response.add(state);

		when(restTemplate.getForEntity("https://api.covid19india.org/v2/state_district_wise.json", String.class))
				.thenReturn(new ResponseEntity<String>(stateData, HttpStatus.OK));
		when(objectMapper.getTypeFactory()).thenReturn(TypeFactory.defaultInstance());
		when(objectMapper.readValue(stateData,
				TypeFactory.defaultInstance().constructCollectionType(List.class, State.class))).thenReturn(response);

		// ACT
		StateWiseCases stateWiseCases = covid19ServiceImpl.getStateWiseCases();

		// VERIFY
		assertNotNull(stateWiseCases);
		assertEquals(state.getState(), stateWiseCases.getStates().get(0).getState());

	}

	@Test
	public void getCovidCasesServiceFails() throws IOException {
		// ARRANGE
		Gson gson = new Gson();
		State state = gson.fromJson(
				"{\"state\":\"Andaman and Nicobar Islands\",\"statecode\":\"AN\",\"districtData\":[{\"district\":\"North and Middle Andaman\",\"notes\":\"\",\"active\":0,\"confirmed\":1,\"deceased\":0,\"recovered\":1,\"delta\":{\"confirmed\":0,\"deceased\":0,\"recovered\":0}}]}",
				State.class);
		List<State> response = new ArrayList<>();
		response.add(state);

		when(restTemplate.getForEntity("https://api.covid19india.org/v2/state_district_wise.json", String.class))
				.thenReturn(new ResponseEntity<String>("", HttpStatus.OK));
		when(objectMapper.readValue("", TypeFactory.defaultInstance().constructCollectionType(List.class, State.class)))
				.thenReturn(response);

		// ACT
		StateWiseCases stateWiseCases = covid19ServiceImpl.getStateWiseCases();

		// VERIFY
		assertNotNull(stateWiseCases);

	}
}
