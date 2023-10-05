package com.nissan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Loan;

@Repository
public interface ILoanRepository extends CrudRepository<Loan, Integer> {

}
