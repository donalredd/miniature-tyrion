package com.receipt.vault.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Country")
public class Country {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
	public Country( String name) {
		this.name=name;			
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
}
