package com.nissan.controller;

import java.nio.file.AccessDeniedException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.entity.Loan;
import com.nissan.service.ILoanService;
//@CrossOrigin
//@RestController //@Controller+@Configuration
@RequestMapping("/api")
public class LoanController {
	@Autowired
	private ILoanService loanService;
	
	@Autowired
	private APIResponse apiResponse;
	

	@GetMapping("/loan")
	public List<Loan> getLoan
	() throws AccessDeniedException{
	//jwtUtil.verify(auth);
	
		return loanService.getLoan();
	}
	
	//searchby id
	@GetMapping("/loan/{id}")
	public Loan getLoan(@PathVariable int id,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException {
		//jwtUtil.verify(auth);
		return loanService.getLoan(id);
		
	}
		
		//add
		@PostMapping("/loanofficer")
		public ResponseEntity<APIResponse> addLoan
		(@RequestBody Loan loan){
			if(loanService.saveLoan(loan)==null) {
				apiResponse.setData("Name can have only alphabets!");
				apiResponse.setStatus(500);
				apiResponse.setError("INVALID NAME");
				
			return ResponseEntity
				.status(apiResponse.getStatus()).body(apiResponse);	
			}
			apiResponse.setData("LOAN ADDED SUCCESSFULLY");
			apiResponse.setStatus(200);
			
			return ResponseEntity
			    .status(apiResponse.getStatus()).body(apiResponse);
			
		}
		@PutMapping("/customer")
		public ResponseEntity<APIResponse> updateCustomer
		(@RequestBody Loan loan){
			if(loanService.saveLoan(loan)==null) {
				apiResponse.setData("Name can have only alphabets!");
				apiResponse.setStatus(500);
				apiResponse.setError("INVALID NAME");
				
			return ResponseEntity
				.status(apiResponse.getStatus()).body(apiResponse);	
			}
			apiResponse.setData("Loan updated SUCCESSFULLY");
			apiResponse.setStatus(200);
			
			return ResponseEntity
			    .status(apiResponse.getStatus()).body(apiResponse);
			
		}
		
		@DeleteMapping("/loan/{id}")
		public void deleteCustomer(@PathVariable int id) {
			loanService.deleteloan(id);
			
		}


}
