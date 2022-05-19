package Entities;

import java.io.Serializable;

public class RevenueReport implements Serializable {

	private static final long serialVersionUID = 583542510006825068L;
	private String month, year,id;
	private String ordersamount;
	private String income;
	private String storeName;
	private String Quarterly;

	public RevenueReport(String storeName, String month, String year,String ordersamount, String income
			,String Quarterly,String id) {
		this.month = month;
		this.year = year;
		this.ordersamount = ordersamount;
		this.income = income;
		this.storeName = storeName;
		this.Quarterly = Quarterly;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getOrdersamount() {
		return ordersamount;
	}

	public void setOrdersamount(String ordersamount) {
		this.ordersamount = ordersamount;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
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
		return "storeName = " + storeName + " month is = " + month + " year is = " + year + " ordersamount is = " + ordersamount + " Quarerly is = " + Quarterly + " income is = " + income+ " id is = " + id;
	}

}
