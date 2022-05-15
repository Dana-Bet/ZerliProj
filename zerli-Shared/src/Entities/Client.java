package Entities;

import java.io.Serializable;

public class Client extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status,creditCardNumber;
	
	public Client(String role, String id, String firstN, String lastN, String userName, String password,String isLoggedIn, String phone,
			String status, String creditCardNumber,String email)
			
	{
		super(role, id, firstN, lastN, userName, password, isLoggedIn,phone, email);
		// TODO Auto-generated constructor stub
		this.status = status;
		this.creditCardNumber = creditCardNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

}
