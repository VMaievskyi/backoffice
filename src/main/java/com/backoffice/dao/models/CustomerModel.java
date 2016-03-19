package com.backoffice.dao.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	private String lastName;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_info")
	private ContactInfoModel contactInfo;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private AddressModel savedAddress;
	private boolean gender;
	private boolean isAnonimous;
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public ContactInfoModel getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(final ContactInfoModel contactInfo) {
		this.contactInfo = contactInfo;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(final boolean gender) {
		this.gender = gender;
	}

	public boolean isAnonimous() {
		return isAnonimous;
	}

	public void setAnonimous(final boolean isAnonimous) {
		this.isAnonimous = isAnonimous;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	public AddressModel getSavedAddress() {
		return savedAddress;
	}

	public void setSavedAddress(final AddressModel savedAddress) {
		this.savedAddress = savedAddress;
	}

}
