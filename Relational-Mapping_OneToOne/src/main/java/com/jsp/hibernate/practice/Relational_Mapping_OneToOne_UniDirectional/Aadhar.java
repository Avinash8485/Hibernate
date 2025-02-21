package com.jsp.hibernate.practice.Relational_Mapping_OneToOne_UniDirectional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Aadhar {
	
	@Id
	private int aadharId;
	private long aadharNo;
	
	//BIDIRECTIONAL USING MAPPEDBY
	 
	@OneToOne(mappedBy = "aadhar")
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	
	/*   BIDIRECTIONAL
	 @OneToOne
	private Person person;
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	*/
	
	/*
	 * For Unidirection either person dataTye of aadhar dataType only need to be there in ethier one class 
	 * here person class have aadhar dataType so no need to do person dataType here.
	 */
	public int getAadharId() {
		return aadharId;
	}
	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	
	
	

}
