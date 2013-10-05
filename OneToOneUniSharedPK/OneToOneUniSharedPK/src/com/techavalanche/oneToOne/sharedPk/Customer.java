package com.techavalanche.oneToOne.sharedPk;

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
@Table(name = "CUSTOMER")
public class Customer implements Serializable { 

	private static final long serialVersionUID = 1L;
	
	private Long custometId;

	private String name;

	private Address address;

	public Customer() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="GEN_CUSTOMER")
	@Column(name = "CUSTOMER_ID")	
	public Long getCustometId() {
		return this.custometId;
	}

	public void setCustometId(Long custometId) {
		this.custometId = custometId;		
		
		if(address != null)
			address.setCustometId(this.custometId);
	}

	@Column(name = "NAME")	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID",insertable=false,updatable=false)	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return "Customer Id : "+this.getCustometId() + "\tCustomer Name : "+ this.getName();
	}

	public int hashCode() {
		return this.getCustometId().hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Customer)
			return this.getCustometId().equals(((Customer) obj).getCustometId());
		else
			return false;
	}
}
