package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.entity.Customer;
import com.nissan.repository.ICustomerRepository;

@Transactional
@Service
public class CustomerServiceImple implements ICustomerService {

	
	@Autowired
	private ICustomerRepository customerRepo;
	
	@Autowired
	private Validation validation;
	
	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepo.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		if(validation.isNameValid(customer.getCustomerName())) {
			return customerRepo.save(customer);
		}
		return null;
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerRepo.findById(id)
				.orElseThrow(()->new 
		RuntimeException("Customer not found for id"+id));
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepo.deleteById(id);
		
	}


	
}
