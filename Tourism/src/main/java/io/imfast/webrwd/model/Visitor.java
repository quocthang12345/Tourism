package io.imfast.webrwd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Visitor {
	@JsonProperty("VisitorID")
	private Long VisitorID;
	@JsonProperty("Username")
	private String Username;
	@JsonProperty("Address")
	private String Address;
	@JsonProperty("Telephone")
	private String Telephone;
	@JsonProperty("Email")
	private String Email;
	@JsonProperty("RentID")
	private Long RentID;
	
	public Long getRentID() {
		return RentID;
	}
	public void setRentID(Long rentID) {
		RentID = rentID;
	}
	public Long getVisitorID() {
		return VisitorID;
	}
	public void setVisitorID(Long visitorID) {
		VisitorID = visitorID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

}
