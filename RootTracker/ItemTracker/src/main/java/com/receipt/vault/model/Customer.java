package com.receipt.vault.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	public Customer(String name, Address address, Set<Order> orders ) {
		this.name = name;
		this.address= address;
		this.customerOrders = orders;
	}

	public Address getAddress() {
		return address;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public Set<Order> getCustomerOrders() {
		return this.customerOrders;
	}
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMER_ORDERS", joinColumns = {
			@JoinColumn(referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "ORDER_ID") })
	private Set<Order> customerOrders = new HashSet<Order>(0);
}
