package com.nissan.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.nissan.entity.Customer;
@Service
public interface ICustomerService {

	// list
	public List<Customer> getCustomer();

	// Insert

	public Customer saveCustomer(Customer customer);

	// update by id
	public Customer getCustomerById(int id);

	// delete
	public void deleteCustomer(int id);


}
