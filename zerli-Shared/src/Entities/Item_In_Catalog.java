package Entities;

import java.io.Serializable;

public class Item_In_Catalog implements Serializable{

	public Item_In_Catalog(int id, String color, String name, String type, Float price, String assembleItem) {
		super();
		this.id = id;
		this.color = color;
		this.name = name;
		this.type = type;
		this.price = price;
		this.assembleItem = assembleItem;
	}
	
	private static final long serialVersionUID = 1L;
	private String color,name;
    private String type;
	private Float price;
	private String assembleItem;
	private int id;
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String isAssembleItem() {
		return assembleItem;
	}
	public void setAssembleItem(String assembleItem) {
		this.assembleItem = assembleItem;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
