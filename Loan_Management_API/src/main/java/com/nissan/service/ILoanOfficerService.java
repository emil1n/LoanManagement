package com.nissan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nissan.entity.LoanOfficer;

@Service
public interface ILoanOfficerService {
	
	//list
	public List<LoanOfficer> getLoanOfficer();
	
	//Insert
	public LoanOfficer saveLoanOfficer(LoanOfficer loanOfficer);
	
	//update by id
	public LoanOfficer getLoanOfficerById(int id);
	
	//delete
	public void deleteLoanOfficer(int id);
	

}
