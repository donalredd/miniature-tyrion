package com.receipt.vault.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String firstLine;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Country country;
	
	public Address(String firstLine, Country country) {
		this.firstLine=firstLine;
		this.country=country;
	
	}
	
	public Country getCountry() {
		return country;
	}
	
	public String getFirstLine() {
		return firstLine;
	}
	
	public long getId() {
		return id;
	}
	
}
