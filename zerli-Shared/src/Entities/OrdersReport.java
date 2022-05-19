package Entities;

import java.io.Serializable;

public class OrdersReport implements Serializable {

	private static final long serialVersionUID = 1983595595251314658L;
	private String month, year;
	private String store;
	private String type;
	private String quantity;

	public OrdersReport(String month, String year, String store, String quantity, String type) {
		super();
		this.month = month;
		this.year = year;
		this.store = store;	
		this.quantity = quantity;
		this.type = type;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFlowerType() {
		return type;
	}

	public void setFlowerType(String type) {
		this.type = type;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String toString() {
		return " month is = " + month + " year is= " + year + " store is: " + store
				+ " Quantity is : " + quantity + " type " + type;
	}

}

