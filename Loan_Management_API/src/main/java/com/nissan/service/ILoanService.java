package com.nissan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nissan.entity.Loan;

@Service
public interface ILoanService {
	//list
		public List<Loan> getLoan();
		
	    //insert
		public Loan saveLoan(Loan loan);
		
	    //get asset type by id
		public Loan getLoan(int id);
	     
		
	    //delete
		public void deleteloan(int id);

}
