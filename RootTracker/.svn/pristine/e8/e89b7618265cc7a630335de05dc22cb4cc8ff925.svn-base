package com.receipt.vault.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Item extends BaseModel {

	@Column(nullable = false)
	@XmlElement
	private String name;

	@Column(nullable = false)
	@XmlElement
	@Temporal(TemporalType.DATE)
	private Date datePurchased;

	@Column(nullable = false)
	@XmlElement
	@Temporal(TemporalType.DATE)
	private Date dateWarrantyExpires;

	@Column(nullable = false)
	@XmlElement
	private boolean remindWhenExpires;

	@Column(nullable = false)
	@XmlElement
	private long numDaysToRemindBeforeExp;

	@Column(nullable = true)
	@XmlElement
	private String description;

	@Column(nullable = true)
	@XmlElement
	private String tags;

	@OneToOne
	@XmlElement
	private Store store;

	@OneToOne
	@XmlElement
	private Category category;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "item_images", joinColumns = { @JoinColumn(referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(referencedColumnName = "ID"), })
	private Set<ImageInfo> images = new HashSet<ImageInfo>();

	public void addImageInfo(ImageInfo imageInfo) {
		this.images.add(imageInfo);
	}

	public Set<ImageInfo> getImages() {
		return images;
	}

	public Item(String name, String description, Store store,
			Category category, String tags) {
		this.setName(name);
		this.description = description;
		this.store = store;
		this.category = category;
		this.tags = tags;

	}

	public Item() {
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Store getStore() {
		return store;
	}

	public Category getCategory() {
		return category;
	}

	public String getTags() {
		return tags;
	}

	public Date getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}

	public Date getDateWarrantyExpires() {
		return dateWarrantyExpires;
	}

	public void setDateWarrantyExpires(Date dateWarrantyExpires) {
		this.dateWarrantyExpires = dateWarrantyExpires;
	}

	public boolean isRemindWhenExpires() {
		return remindWhenExpires;
	}

	public void setRemindWhenExpires(boolean remindWhenExpires) {
		this.remindWhenExpires = remindWhenExpires;
	}

	public long getNumDaysToRemindBeforeExp() {
		return numDaysToRemindBeforeExp;
	}

	public void setNumDaysToRemindBeforeExp(long numDaysToRemindBeforeExp) {
		this.numDaysToRemindBeforeExp = numDaysToRemindBeforeExp;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}
}
