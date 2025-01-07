package com.spds.fps.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author abinjola
 *This class was creaded on 19-Dec-2024.
 */

@RestController
@RequestMapping("/api/v1/")
public class DemoController {
	
	@GetMapping("/test")
	ResponseEntity<String> getUserDetails() throws Exception {
		return new ResponseEntity<>("This end point is secure with JWT.ss", HttpStatus.OK);
	}
	

}
