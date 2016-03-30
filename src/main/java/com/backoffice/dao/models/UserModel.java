package com.backoffice.dao.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jersey.repackaged.com.google.common.collect.Sets;

@Entity(name = "user")
public class UserModel {

	@Id
	private String userName;

	private String firstName;
	private String lastName;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private AddressModel savedAddress;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private CartModel cart;

	private boolean gender;
	private boolean isAnonimous;
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	private String password;
	private boolean enabled;

	private final Set<UserRoleModel> userRole = Sets.newHashSet();

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

	public CartModel getCart() {
		return cart;
	}

	public void setCart(final CartModel cart) {
		this.cart = cart;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRoleModel> getUserRole() {
		return userRole;
	}

}
