package Entities;

import java.io.Serializable;

public class RevenueReport implements Serializable {

	private static final long serialVersionUID = 583542510006825068L;
	private String month, year;
	private int ordersamount;
	private float income;
	private String storeName;
	private String Quarterly;

	public RevenueReport(String storeName, String month, String year, String Quarterly, int ordersamount,
			float income) {
		this.month = month;
		this.year = year;
		this.ordersamount = ordersamount;
		this.income = income;
		this.storeName = storeName;
		this.Quarterly = Quarterly;

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

	public int getOrdersamount() {
		return ordersamount;
	}

	public void setOrdersamount(int ordersamount) {
		this.ordersamount = ordersamount;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getQuarterly() {
		return Quarterly;
	}

	public void setQuarterly(String quarterly) {
		Quarterly = quarterly;
	}

	public String toString() {
		return "storeName = " + storeName + " month is= " + month + " year is: " + year
				+ " Quarerly is : " + Quarterly + " ordersamount is " + ordersamount + " income is " + income;
	}

}
