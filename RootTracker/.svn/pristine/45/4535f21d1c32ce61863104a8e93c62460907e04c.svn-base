package com.receipt.vault.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;

@Entity
@XmlRootElement(name = "user")
public class User extends BaseModel implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 7367750120608550590L;

    public User() {
    }

    @Column(unique = true)
    @XmlElement(name = "email")
    private String email;

    @Column(nullable = false)
    @XmlElement(name = "name")
    private String name;

    @Column(nullable = false)
    private String password;

    public User(String email, String name, String password) {
	this.email = email;
	this.name = name;
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public String getName() {
	return name;
    }

    public String getPassword() {
	return password;
    }

    @Override
    public boolean equals(Object that) {
	if (that instanceof User) {
	    User rhs = (User) that;
	    EqualsBuilder builder = new EqualsBuilder();
	    builder.append(rhs.getEmail(), this.getEmail());
	    return builder.isEquals();
	}
	return false;

    }

    @Override
    public int hashCode() {
	int magicNumber = 71;
	return getEmail().hashCode() * magicNumber;
    }
}
