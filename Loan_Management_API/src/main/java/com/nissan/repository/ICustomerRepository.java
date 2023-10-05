package com.nissan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Customer;
@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer>{

//	@Modifying
//	@Query("update com.LoanManagementApplication.model.Customer set isActive=0 where customerId=?1")
//	public void disableCustomer(Integer customerId);
}
