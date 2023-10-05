package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.entity.Loan;
import com.nissan.repository.ILoanRepository;

@Transactional
@Service
public class LoanServiceImple implements ILoanService {

	@Autowired
	private ILoanRepository loanRepo;
	@Autowired
	private Validation validation;

	public List<Loan> getLoan() {
		return (List<Loan>) loanRepo.findAll();
	}

	@Override
	public Loan saveLoan(Loan loan) {

		return loanRepo.save(loan);
	}

	@Override
	public Loan getLoan(int id) {
		// TODO Auto-generated method stub
		return loanRepo.findById(id).orElseThrow(() -> new RuntimeException("Loan not found for id " + id));
	}

	@Override
	public void deleteloan(int id) {
		loanRepo.deleteById(id);

	}

}
