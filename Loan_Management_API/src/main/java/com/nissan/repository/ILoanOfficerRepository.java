package com.nissan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.LoanOfficer;

@Repository
public interface ILoanOfficerRepository  extends CrudRepository<LoanOfficer, Integer>{

}
