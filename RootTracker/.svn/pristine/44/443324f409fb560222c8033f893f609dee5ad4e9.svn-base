package com.receipt.vault.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "CUSTOMER_ORDER")
public class Order {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String orderId;

    @Column
    private Date orderDate;

    public Order(Date orderDate, String orderId) {
	this.orderDate = orderDate;
	this.orderId = orderId;
    }

    public Date getOrderDate() {
	return orderDate;
    }

    public long getId() {
	return id;
    }

    public String getOrderId() {
	return orderId;
    }

    @Override
    public boolean equals(Object that) {
	if (that instanceof Order) {
	    if (((Order) that).getOrderId().equals(this.getOrderId())) {
		return true;
	    } else {
		return false;
	    }
	}
	return false;
    }

    @Override
    public int hashCode() {

	return (71 * this.getOrderId().hashCode());
    }
}
