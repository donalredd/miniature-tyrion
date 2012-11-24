package com.receipt.vault.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Category extends BaseModel {

	@Column(nullable = false)
	private String name;

	public Category(String name) {
		this.name = name;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
