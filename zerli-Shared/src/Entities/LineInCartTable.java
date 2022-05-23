package Entities;

import java.io.Serializable;

public class LineInCartTable{

	private int id;
	private int quan;
	private String name;
	private String  IsAss;
	private float  price ;
	
	public LineInCartTable(int id , int quan, String name , String IsAss,Float price) {
		this.id=id;
		this.quan=quan;
		this.name=name;
		this.IsAss=IsAss;
		this.price=price;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuan() {
		return quan;
	}

	public void setQuan(int quan) {
		this.quan = quan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsAss() {
		return IsAss;
	}

	public void setIsAss(String isAss) {
		IsAss = isAss;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	

}