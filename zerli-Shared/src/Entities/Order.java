package Entities;

import java.io.Serializable;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private int orderNumber;
	private int price;
	private String greetingCard;
	private String store;
    private String ClientId;
    private String SupplimentMethod;
    private String status;
    private String suppTimeS;
    private String orderTimeS;
    
	public OrderTime orderTime = null;
	public OrderTime suppTime = null;
	public Delivery delivery =null;

	public Order(int OrderNumber,int price,String greetingCard,
			String store,String ClientId,String suppTime,String suppmethod)
	{
		this.orderNumber = OrderNumber;
		this.price = price;
		this.greetingCard =greetingCard;
		this.status = "waiting for confirmation";
		this.SupplimentMethod = suppmethod;
		this.store = store;
		this.ClientId = ClientId;
		this.suppTimeS = orderTime.toString();
		this.orderTimeS = suppTime.toString();
	
	}

	
	public int getOrderNumber()
	{
		return orderNumber;	
	}
	
	public void setOrderNumber(int ordernumber)
	{
		orderNumber = ordernumber;
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

	public String getStore() {
		return store;
	}

	public String getClientId() {
		return ClientId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getSupplimentMethod() {
		return SupplimentMethod;
	}


	public String getSuppTimeS() {
		return suppTimeS;
	}


	public String getOrderTimeS() {
		return orderTimeS;
	}


	public Delivery getDelivery() {
		return delivery;
	}


	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	


}
