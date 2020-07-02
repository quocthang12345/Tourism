package io.imfast.webrwd.model;

public class User extends Abstract<User> {
	private Long UserID;
	private String Password;
	private String Username;
	private String Address;
	private String Email;
	private int Telephone;
	private String Birthday;
	private int Status;
	private Long RoleID;
	private Long HistoryID;
	private Role Role = new Role();
	public Long getUserID() {
		return UserID;
	}
	public void setUserID(Long userID) {
		UserID = userID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getTelephone() {
		return Telephone;
	}
	public void setTelephone(int telephone) {
		Telephone = telephone;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public Long getRoleID() {
		return RoleID;
	}
	public void setRoleID(Long roleID) {
		RoleID = roleID;
	}
	public Long getHistoryID() {
		return HistoryID;
	}
	public void setHistoryID(Long historyID) {
		HistoryID = historyID;
	}
	public Role getRole() {
		return Role;
	}
	public void setRole(Role role) {
		Role = role;
	}
	
	
}
