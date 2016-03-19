package com.backoffice.dao.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class AddressModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String country;
	private String postalCode;
	private String city;
	private String street;
	private String building;
	private String appartment;
	private String doorCode;
	@Lob
	private String additionalInfo;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(final String building) {
		this.building = building;
	}

	public String getAppartment() {
		return appartment;
	}

	public void setAppartment(final String appartment) {
		this.appartment = appartment;
	}

	public String getDoorCode() {
		return doorCode;
	}

	public void setDoorCode(final String doorCode) {
		this.doorCode = doorCode;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(final String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(final String postalCode) {
		this.postalCode = postalCode;
	}

}
