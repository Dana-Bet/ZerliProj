package Entities;

import java.io.Serializable;

public class Store implements Serializable{

	private static final long serialVersionUID = 6163898968170345743L;
	private String  city, address,storeCode;


	public Store(String storeCode,String city, String address) {
		this.storeCode = storeCode;
		this.city = city;
		this.address=address;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public String getstoreCode() {
		return storeCode;
	}
	
	public String toString() {
		return this.city + " " + this.address; 
	}
}
