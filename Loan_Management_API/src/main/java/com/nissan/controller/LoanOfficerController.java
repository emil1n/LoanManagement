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
import com.nissan.entity.Customer;
import com.nissan.entity.LoanOfficer;
import com.nissan.service.ILoanOfficerService;



@CrossOrigin
@RestController //@Controller+@Configuration
@RequestMapping("/api")
public class LoanOfficerController {
	@Autowired
	private ILoanOfficerService loanOfficerService;
	
	@Autowired
	private APIResponse apiResponse;
	

	@GetMapping("/loanofficer")
	public List<LoanOfficer> getLoanOfficer
	() throws AccessDeniedException{
	//jwtUtil.verify(auth);
	
		return loanOfficerService.getLoanOfficer();
	}
	
	//searchby id
	@GetMapping("/loanofficer/{id}")
	public LoanOfficer getLoanOfficer(@PathVariable int id,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException {
		//jwtUtil.verify(auth);
		return loanOfficerService.getLoanOfficerById(id);
		
	}
		
		//add
		@PostMapping("/loanofficer")
		public ResponseEntity<APIResponse> addLoan
		(@RequestBody LoanOfficer loanofficer){
			if(loanOfficerService.saveLoanOfficer(loanofficer)==null) {
				apiResponse.setData("Name can have only alphabets!");
				apiResponse.setStatus(500);
				apiResponse.setError("INVALID NAME");
				
			return ResponseEntity
				.status(apiResponse.getStatus()).body(apiResponse);	
			}
			apiResponse.setData("LOAN Officer ADDED SUCCESSFULLY");
			apiResponse.setStatus(200);
			
			return ResponseEntity
			    .status(apiResponse.getStatus()).body(apiResponse);
			
		}
		@PutMapping("/loanofficer")
		public ResponseEntity<APIResponse> updateCustomer
		(@RequestBody LoanOfficer loanofficer){
			if(loanOfficerService.saveLoanOfficer(loanofficer)==null) {
				apiResponse.setData("Name can have only alphabets!");
				apiResponse.setStatus(500);
				apiResponse.setError("INVALID NAME");
				
			return ResponseEntity
				.status(apiResponse.getStatus()).body(apiResponse);	
			}
			apiResponse.setData("Loan officer updated SUCCESSFULLY");
			apiResponse.setStatus(200);
			
			return ResponseEntity
			    .status(apiResponse.getStatus()).body(apiResponse);
			
		}
		
		@DeleteMapping("/loanofficer/{id}")
		public void deleteCustomer(@PathVariable int id) {
			loanOfficerService.deleteLoanOfficer(id);
			
		}

}
