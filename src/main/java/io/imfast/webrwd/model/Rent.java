package io.imfast.webrwd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rent extends Abstract<Rent> {
	@JsonProperty("RentID")
	private Long RentID;
	@JsonProperty("UserID")
	private Long UserID;
	@JsonProperty("ItemID")
	private Long ItemID;
	@JsonProperty("RentDetail")
	private String RentDetail;
	@JsonProperty("Cost")
	private String Cost;
	@JsonProperty("Status")
	private int Status;
	
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public Long getRentID() {
		return RentID;
	}
	public void setRentID(Long rentID) {
		RentID = rentID;
	}
	public Long getUserID() {
		return UserID;
	}
	public void setUserID(Long userID) {
		UserID = userID;
	}
	public Long getItemID() {
		return ItemID;
	}
	public void setItemID(Long itemID) {
		ItemID = itemID;
	}
	public String getRentDetail() {
		return RentDetail;
	}
	public void setRentDetail(String rentDetail) {
		RentDetail = rentDetail;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	
	
	
}
