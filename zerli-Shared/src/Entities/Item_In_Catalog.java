package Entities;

import java.io.Serializable;

public class zerType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String id,color,flowername;


	private float price;
	private Flowertype flowertype;

	public zerType(String id,String flowername,String color,float price,Flowertype flowertype) {
		this.id = id;
		this.color = color;
		this.price = price;
		this.flowertype = flowertype;
		this.flowername = flowername;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getFlowername() {
		return flowername;
	}

	public void setFlowername(String flowername) {
		this.flowername = flowername;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	public Flowertype getFlowertype() {
		return flowertype;
	}

	public void setFlowertype(Flowertype flowertype) {
		this.flowertype = flowertype;
	}
	@Override
	public String toString() {
		return "Dish [id=" + id + ", price=" + price + ", color=" + color + ", flowertype="
				+ flowertype + "]";
	}
}
