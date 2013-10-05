package com.techavalanche.oneToOne.fk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PASSPORT")
public class Passport implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="GEN_PASSPORT")
	@Column(name = "PASSPORT_ID")	
	private Long passportId;
	
	@Column(name = "PASSPORT_NO")
	private String passportNo;
	
	@OneToOne(mappedBy="passport")
	private Person person;	

	public Passport() {
		super();
	}   

	public Long getPassportId() {
		return passportId;
	}

	public void setPassportId(Long passportId) {
		this.passportId = passportId;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String toString() {
		return "Passport Id : "+this.getPassportId() + "\tPassport No. : "+ this.getPassportNo();
	}	

	public int hashCode() {
		return this.getPassportNo().hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Passport)
			return this.getPassportId().equals(((Passport) obj).getPassportId());
		else
			return false;
	}	
}
