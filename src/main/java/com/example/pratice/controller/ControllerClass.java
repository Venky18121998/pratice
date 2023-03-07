package com.example.pratice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pratice.model.AbhiDetails;
import com.example.pratice.pojo.AbhiDetailsPojo;
import com.example.pratice.service.AbhiMadhuService;

@RestController
@RequestMapping("/saving")
public class ControllerClass {

	@Autowired
	AbhiMadhuService abhiMadhuService;

	@PostMapping("/saveDetails")
	public ResponseEntity<AbhiDetailsPojo> creatingEmployeeDetails(@RequestBody AbhiDetailsPojo abhiDetailsPojo) {

		AbhiDetailsPojo abhiPojo = abhiMadhuService.saveDetails(abhiDetailsPojo);

		if (abhiPojo != null) {

			return new ResponseEntity<AbhiDetailsPojo>(abhiPojo, HttpStatus.CREATED);

		} else {
			return new ResponseEntity<AbhiDetailsPojo>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@GetMapping("/getAllDetails")
	public ResponseEntity<AbhiDetails> getDetailsPersons() {

		List<AbhiDetails> abh = abhiMadhuService.getAllDetails();
		if (abh != null) {
			return new ResponseEntity<AbhiDetails>(HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<AbhiDetails>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/getBy/{Id}")

	public ResponseEntity<AbhiDetails> fetchingDetailsBasedOnId(@PathVariable int Id) {

		AbhiDetails abc = abhiMadhuService.getDetailsById(Id);

		if (abc != null) {
			return new ResponseEntity<AbhiDetails>(abc, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<AbhiDetails>(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/updateDetails/{Id}")
	public ResponseEntity<AbhiDetails> updateUserDetails(@PathVariable int Id,
			@RequestBody AbhiDetailsPojo abhiDetailsPojo) {

		AbhiDetails details = abhiMadhuService.updateDetailsBasedOnId(Id,abhiDetailsPojo);
		if (details != null) {
			return new ResponseEntity<AbhiDetails>(details, HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<AbhiDetails>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

}
