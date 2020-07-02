package io.imfast.webrwd.model;

public class BusinessAreas extends Abstract<BusinessAreas> {
	private Long BusinessID;
	private String Name;
	private String Code;
	
	public Long getBusinessID() {
		return BusinessID;
	}
	public void setBusinessID(Long businessID) {
		BusinessID = businessID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	
	
}
