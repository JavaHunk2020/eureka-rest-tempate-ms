package com.springboot.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.dto.AppResponse;
import com.springboot.web.dto.SignupDTO;
import com.springboot.web.service.SignupService;

@RestController
@RequestMapping("/v2")
public class SignupRestController {
	
	@Autowired
	private SignupService signupService;
	
	@DeleteMapping("/signups/{sid}")
	public AppResponse deleteSignupById(@PathVariable int sid) {
		signupService.deleteById(sid);
		AppResponse newapp = new AppResponse();
		newapp.setCode("123");
		newapp.setMessage("the item is deleted successfully");
		return newapp;
	}
	
	@GetMapping("/signups/{sid}")
	public SignupDTO showsignup(@PathVariable int sid) {
		SignupDTO signupDTO = signupService.findBySid(sid).get();
		return signupDTO ;
	}
	
	
	@GetMapping("/signups")
	public List<SignupDTO> showsignup() {
		List<SignupDTO> signupDTOs = signupService.findAll();
		System.out.println(signupDTOs);
		return signupDTOs ;
	}
	
	@PostMapping("/signups")
	public AppResponse addSignup(@RequestBody SignupDTO signupdto) {
		signupService.persist(signupdto);
		AppResponse newapp = new AppResponse();
		newapp.setCode("123");
		newapp.setMessage("User added successfuly ");
		return newapp;
	}
	
	
}
