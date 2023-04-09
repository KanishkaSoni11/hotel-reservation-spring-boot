package com.example.hotelreservation.model;

public class Customer {

	public Customer() {

	}

	private String customerID;
	private String password;
	private String firstName;
	private String lastName;
	private String street;
	private String state;
	private int zipCode;
	private String emailId;
	private int contactNumber;
	private String identificationNumber;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String
	toString() {
		final StringBuilder sb = new StringBuilder("Customer{");
		sb.append("customerID=").append(customerID);
		sb.append(", password='").append(password).append('\'');
		sb.append(", firstName='").append(firstName).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", street='").append(street).append('\'');
		sb.append(", state='").append(state).append('\'');
		sb.append(", zipCode=").append(zipCode);
		sb.append(", emailId='").append(emailId).append('\'');
		sb.append(", contactNumber=").append(contactNumber);
		sb.append(", identificationNumber='").append(identificationNumber).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
