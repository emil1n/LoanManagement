package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.entity.LoanOfficer;
import com.nissan.repository.ILoanOfficerRepository;

@Service
public class LoanOfficerImle  implements ILoanOfficerService{
	@Autowired
	private ILoanOfficerRepository officerRepo;

	@Override
	public List<LoanOfficer> getLoanOfficer() {
		return (List<LoanOfficer>) officerRepo.findAll();
	}

	@Override
	public LoanOfficer saveLoanOfficer(LoanOfficer loanOfficer) {
		return officerRepo.save(loanOfficer);
	}

	@Override
	public LoanOfficer getLoanOfficerById(int id) {
		return officerRepo.findById(id)
				.orElseThrow(()->new 
		RuntimeException("vendor not found for id"+ id));
	}

	@Override
	public void deleteLoanOfficer(int id) {
		officerRepo.deleteById(id);
		
	}


}
