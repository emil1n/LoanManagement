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
import com.nissan.service.ICustomerService;

@CrossOrigin
@RestController //@Controller+@Configuration
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private APIResponse apiResponse;
	

	@GetMapping("/customer")
	public List<Customer> getCustomer
	() throws AccessDeniedException{
	//jwtUtil.verify(auth);
	
		return customerService.getCustomer();
	}
	
	//searchby id
		@GetMapping("/customer/{id}")
		public Customer getCustomer(@PathVariable int id,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException {
			//jwtUtil.verify(auth);
			return customerService.getCustomerById(id);
			
		}
		
		//add
		@PostMapping("/customer")
		public ResponseEntity<APIResponse> addCustomer
		(@RequestBody Customer customer){
			if(customerService.saveCustomer(customer)==null) {
				apiResponse.setData("Name can have only alphabets!");
				apiResponse.setStatus(500);
				apiResponse.setError("INVALID NAME");
				
			return ResponseEntity
				.status(apiResponse.getStatus()).body(apiResponse);	
			}
			apiResponse.setData("CUSTOMER ADDED SUCCESSFULLY");
			apiResponse.setStatus(200);
			
			return ResponseEntity
			    .status(apiResponse.getStatus()).body(apiResponse);
			
		}
		@PutMapping("/customer")
		public ResponseEntity<APIResponse> updateCustomer
		(@RequestBody Customer customer){
			if(customerService.saveCustomer(customer)==null) {
				apiResponse.setData("Name can have only alphabets!");
				apiResponse.setStatus(500);
				apiResponse.setError("INVALID NAME");
				
			return ResponseEntity
				.status(apiResponse.getStatus()).body(apiResponse);	
			}
			apiResponse.setData("Customer updated SUCCESSFULLY");
			apiResponse.setStatus(200);
			
			return ResponseEntity
			    .status(apiResponse.getStatus()).body(apiResponse);
			
		}
		
		@DeleteMapping("/customer/{id}")
		public void deleteCustomer(@PathVariable int id) {
			customerService.deleteCustomer(id);
			
		}
	
	
	
	
	

}
