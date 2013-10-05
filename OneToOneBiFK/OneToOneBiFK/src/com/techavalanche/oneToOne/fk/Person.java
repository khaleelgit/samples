package com.techavalanche.oneToOne.fk;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable { 

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="GEN_PERSON")
	@Column(name = "PERSON_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="PASS_ID",insertable=true,updatable=true,nullable=true,unique=true)
	private Passport passport;

	public Person() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public String toString() {
		return "Person Id : "+this.getId() + "\tPerson Name : "+ this.getName();
	}

	public int hashCode() {
		return this.getId().hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Person)
			return this.getId().equals(((Person) obj).getId());
		else
			return false;
	}
}
