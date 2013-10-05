package com.techavalanche.oneToOne.sharedPk;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long custometId;
	
	private String city;
	
	private String country;
	
	private Customer customer;

	@Id
	@Column(name = "CUSTOMER_ID")	
	public Long getCustometId() {
		return custometId;
	}

	public void setCustometId(Long custometId) {
		this.custometId = custometId;
	}

	@Column(name = "CITY")	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "COUNTRY")	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID",insertable=false,updatable=false)	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int hashCode() {
		return custometId.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Address)
			return this.getCustometId().equals(((Address) obj).getCustometId());
		else
			return false;
	}

	public String toString() {
		return "City = "+this.getCity()+" : Country = "+this.getCountry();
	}
}
