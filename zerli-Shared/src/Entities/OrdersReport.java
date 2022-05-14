package Entities;

import java.io.Serializable;

public class OrdersReport implements Serializable {

	private static final long serialVersionUID = 1983595595251314658L;
	private String month, year;
	private String store;
	private String flowerType;
	private int Quantity;

	public OrdersReport(String month, String year, String store, String flowerType, int quantity) {
		super();
		this.month = month;
		this.year = year;
		this.store = store;	
		this.flowerType = flowerType;
		Quantity = quantity;
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
		return flowerType;
	}

	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		this.Quantity = quantity;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String toString() {
		return " store is = " + store + " month is= " + month + " year is: " + year
				+ " Quantity is : " + Quantity + " flowerType " + flowerType;
	}

}

