package com.receipt.vault.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Role extends BaseModel {

	@Column(nullable = false)
	private String name;

	public Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
