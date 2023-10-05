package com.nissan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loan {
	
	// id
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "loanId ")
		private int loanId;
		
		// loan type
		@Column(name = " loanType", nullable = false)
		private String loanType;
		 
		//loan rate
		@Column(name = "rate")
		private Integer rate;
		
		//duration
		@Column(name = "duration")
		private Integer duration;
		
		//amount
		@Column(name = "amount")
		private Integer amount;
		
		// officer id
		@Column(name = "officerId")
		private Integer officerId;
		@ManyToOne
		@JoinColumn(name = "officerId", insertable = false, updatable = false)
		private LoanOfficer loanOfficer;
		
		
		public Integer getOfficerId() {
			return officerId;
		}


		public void setOfficerId(Integer officerId) {
			this.officerId = officerId;
		}


		public LoanOfficer getLoanOfficer() {
			return loanOfficer;
		}


		public void setLoanOfficer(LoanOfficer loanOfficer) {
			this.loanOfficer = loanOfficer;
		}


		// isActive
		private boolean isActive = true;


		public int getLoanId() {
			return loanId;
		}


		public void setLoanId(int loanId) {
			this.loanId = loanId;
		}


		public String getLoanType() {
			return loanType;
		}


		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}


		public Integer getRate() {
			return rate;
		}


		public void setRate(Integer rate) {
			this.rate = rate;
		}


		public Integer getDuration() {
			return duration;
		}


		public void setDuration(Integer duration) {
			this.duration = duration;
		}


		public Integer getAmount() {
			return amount;
		}


		public void setAmount(Integer amount) {
			this.amount = amount;
		}


		public boolean isActive() {
			return isActive;
		}


		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}


		@Override
		public String toString() {
			return "loan [loanId=" + loanId + ", loanType=" + loanType + ", rate=" + rate + ", duration=" + duration
					+ ", amount=" + amount + ", isActive=" + isActive + "]";
		}
		
		
		

		
	

}
