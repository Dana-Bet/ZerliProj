package Entities;

import java.io.Serializable;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private int OrderNumber;
	private int price;
	private String greetingCard;
	private String color;
	private String dOrder;
	private String shop;
	private String date;
	private String orderDate;
	
	//Builder to update order
	public Order(int OrderNumber,int price,String greetingCard,
			String color,String dOrder,String shop,String date,String orderDate)
	{
		this.OrderNumber = OrderNumber;
		this.price = price;
		this.greetingCard =greetingCard;
		this.color = color;
		this.dOrder = dOrder;
		this.shop = shop;
		this.date = date;
		this.orderDate = orderDate;
	}
	
	public int getOrderNumber()
	{
		return OrderNumber;	
	}
	
	public void setOrderNumber(int ordernumber)
	{
		OrderNumber = ordernumber;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public String getGreetingCard()
	{
		return greetingCard;
	}
	
	public void setGreetingCard(String greetingCard)
	{
		this.greetingCard = greetingCard;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public String getDOrder()
	{
		return dOrder;
	}
	
	public void setDOrder(String dOrder)
	{
		this.dOrder = dOrder;
	}
	
	public String getShop()
	{
		return shop;
		
	}
	
	public void setShop(String shop)
	{
		this.shop = shop;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getOrderDate()
	{
		return orderDate;
	}
	
	public void setOrderDate(String orderdate)
	{
		this.orderDate = orderdate;
	}
}
