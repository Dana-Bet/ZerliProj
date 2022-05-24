package Entities;

import java.io.Serializable;

public class Delivery {
	private String city;
    private String Address;
    private String phone;
    private String reciverName;
	
    public Delivery(String city, String address, String phone, String reciverName) {
		this.city = city;
		Address = address;
		this.phone = phone;
		this.reciverName = reciverName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReciverName() {
		return reciverName;
	}

	public void setReciverName(String reciverName) {
		this.reciverName = reciverName;
	}


}
