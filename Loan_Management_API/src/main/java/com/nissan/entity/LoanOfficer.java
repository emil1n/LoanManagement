package com.nissan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class LoanOfficer {

	// id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "officerId ")
	private int officerId;

	// l name
	@Column(name = "OfficerName", nullable = false)
	private String lOfficerName;

	// phone number
	@Column(name = "officerMob")
	private String officerMob;

	// isActive
			private boolean isActive = true;
	public boolean isActive() {
				return isActive;
			}

			public void setActive(boolean isActive) {
				this.isActive = isActive;
			}

	public int getOfficerId() {
		return officerId;
	}

	public void setOfficerId(int officerId) {
		this.officerId = officerId;
	}

	public String getlOfficerName() {
		return lOfficerName;
	}

	public void setlOfficerName(String lOfficerName) {
		this.lOfficerName = lOfficerName;
	}

	public String getOfficerMob() {
		return officerMob;
	}

	public void setOfficerMob(String officerMob) {
		this.officerMob = officerMob;
	}
	

}
