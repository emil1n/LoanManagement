package com.nissan.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_Table")
public class Customer {
	
	
	//id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	private Integer customerId;
	
	// customer Name
		@Column(name = "customerName")
		private String customerName;
		
		//phone number
		@Column(name = "customerMob")
		private String customerMob;
		
		//loan id
		@Column(name = "loanId")
		private Integer loanId;
		@ManyToOne
		@JoinColumn(name = "loanId", insertable = false, updatable = false)
		private Loan loan;
		
		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		//  from
		@Column(name = "loanFrom")
		private LocalDate loanFrom;
		
		// isActive
				private boolean isActive = true;

//		public Customer() {
//			super();
//		}
//
//		public Customer(Integer customerId, String customerName, String customerMob, Integer loanId, Loan loan,
//				LocalDate loanFrom) {
//			super();
//			this.customerId = customerId;
//			this.customerName = customerName;
//			this.customerMob = customerMob;
//			this.loanId = loanId;
//			this.loan = loan;
//			this.loanFrom = loanFrom;
//		}

		public Integer getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Integer customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerMob() {
			return customerMob;
		}

		public void setCustomerMob(String customerMob) {
			this.customerMob = customerMob;
		}

		public Integer getLoanId() {
			return loanId;
		}

		public void setLoanId(Integer loanId) {
			this.loanId = loanId;
		}

		public Loan getLoan() {
			return loan;
		}

		public void setLoan(Loan loan) {
			this.loan = loan;
		}

		public LocalDate getLoanFrom() {
			return loanFrom;
		}

		public void setLoanFrom(LocalDate loanFrom) {
			this.loanFrom = loanFrom;
		}
		
		
		
		
		
		
	
	

}
