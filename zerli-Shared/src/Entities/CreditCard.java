package Entities;

import java.io.Serializable;

public class CreditCard implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String creditNumber;
	
	public CreditCard(String creditNumber) {
		this.creditNumber = creditNumber;
	}
	
	public String getCreditCard() {
		return this.creditNumber;
	}

	@Override
	public String toString() {
		String fourLastNum; 
		int len =this.creditNumber.length();
		fourLastNum = this.creditNumber.substring(len-4, len);
		return "**** **** **** "+fourLastNum ;
	}


}
