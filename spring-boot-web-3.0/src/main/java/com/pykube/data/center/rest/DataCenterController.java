package com.pykube.data.center.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/mba")
public class DataCenterController {
	
	
	 @Autowired private RestTemplate restTemplate;
	 
	//http://localhost:7777/mba/signup/100/carttype"
	@GetMapping("/signup/{sid}/carttype")
	public Map<String,Object> findData(@PathVariable int sid){
		  //Call other micoservices
	        
	        Map<String,Object> input=new HashMap<String, Object>();
	        input.put("sid", sid);
	        //THIS IS FETCHING SINHLE RESULT
	        SignupDTO signupDTO = restTemplate.getForObject("http://SIGNUP-SERVICE/v2/signups/{sid}", SignupDTO.class, input);
	        
	        
	         HttpHeaders getHeaders = new HttpHeaders();
	         getHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	         HttpEntity<CreditCardTypeDTO> entity = new HttpEntity<CreditCardTypeDTO>(getHeaders);
	         List<CreditCardTypeDTO> creditCardsList=new ArrayList<>();
	       //THIS IS FETCHING MUTIPLE OBJECTS
	 	   	ResponseEntity<? extends List>  result = restTemplate.exchange("http://card-service"+"/v1/cardtypes",HttpMethod.GET,entity,creditCardsList.getClass());
		
	 	 	Map<String,Object> data =new HashMap<>();
	 	 	data.put("signup", signupDTO);
	 	 	data.put("cardTypes", result.getBody());
		    return data;
	}

}
