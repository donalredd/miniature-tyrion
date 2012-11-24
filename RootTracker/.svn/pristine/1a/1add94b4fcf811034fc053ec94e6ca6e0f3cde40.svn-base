package com.receipt.vault.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Store extends BaseModel {

	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String salesPerson;

	@Column(nullable = true)
	private String address;

	@Column(nullable = true)
	private String map;

	@Column(nullable = true)
	private String phoneNumber;

	@Column(nullable = true)
	private String notes;

	public Store() {
	}
	
	
	public void setName(String name) {
		this.name = name;
	}


	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setMap(String map) {
		this.map = map;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Store(String name, String salesPerson, String address, String map,
			String phoneNumber, String notes) {

		this.name = name;
		this.salesPerson = salesPerson;
		this.address = address;
		this.map = map;
		this.phoneNumber = phoneNumber;
		this.notes = notes;

	}

	public String getName() {
		return name;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public String getAddress() {
		return address;
	}

	public String getMap() {
		return map;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getNotes() {
		return notes;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
