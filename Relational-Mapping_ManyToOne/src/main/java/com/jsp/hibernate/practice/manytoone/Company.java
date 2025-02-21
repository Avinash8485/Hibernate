package com.jsp.hibernate.practice.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	private int companyId;
	private String companyNmae;

	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyNmae() {
		return companyNmae;
	}
	public void setCompanyNmae(String companyNmae) {
		this.companyNmae = companyNmae;
	}



}
