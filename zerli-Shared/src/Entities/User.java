package Entities;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 8530287836358627004L;
	private String userName, password, isLoggedIn, role, id, firstN, lastN, email,Phone;

	public User(String role, String id, String firstN, String lastN, String userName,
			String password, String isLoggedIn, String phone) {
		this.role = role;
		this.id = id;
		this.firstN = firstN;
		this.lastN = lastN;
		this.userName = userName;
		this.password = password;
		this.isLoggedIn = isLoggedIn;
		this.Phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstN() {
		return firstN;
	}

	public void setFirstN(String firstN) {
		this.firstN = firstN;
	}

	public String getLastN() {
		return lastN;
	}

	public void setLastN(String lastN) {
		this.lastN = lastN;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(String isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		this.Phone = phone;
	}

}
