package com.pravnainfo.pravnainformatika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravnainfo.pravnainformatika.dto.LoginRequest;
import com.pravnainfo.pravnainformatika.dto.UserDTO;
import com.pravnainfo.pravnainformatika.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/korisnik")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody LoginRequest request){
		
		return userService.login(request);
		
	}
	
	@GetMapping("/{korisnickoIme}")
	public ResponseEntity<UserDTO> getUser(@PathVariable(name = "korisnickoIme") String userName){
		
		return userService.getUser(userName);
		
	}
	
	@PostMapping()
	public ResponseEntity<UserDTO> register(@RequestBody LoginRequest request){
		
		return userService.login(request);
		
	}
}
