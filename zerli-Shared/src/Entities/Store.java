package Entities;

import java.io.Serializable;

public class Store implements Serializable{

	private static final long serialVersionUID = 6163898968170345743L;
	private String supplierName, openning, city, address,storeCode;


	public Store(String storeCode, String supplierName, String openning, String city, String address) {
		this.storeCode = storeCode;
		this.supplierName = supplierName;
		this.openning = openning;
		this.city = city;
		this.address=address;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public String getOpenning() {
		return openning;
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
}
