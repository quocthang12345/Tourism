package io.imfast.webrwd.model;

public class Cooperator extends Abstract<Cooperator> {
	private Long CooperatorID;
	private String Name;
	private String Address;
	private int Telephone;
	private String Email;
	
	public Long getCooperatorID() {
		return CooperatorID;
	}
	public void setCooperatorID(Long cooperatorID) {
		CooperatorID = cooperatorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getTelephone() {
		return Telephone;
	}
	public void setTelephone(int telephone) {
		Telephone = telephone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
}
