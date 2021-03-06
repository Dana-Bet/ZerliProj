package Entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private int orderNumber;
	private String price;
	private String greetingCard;
	private String store;
    private String ClientId;
    private String SupplimentMethod;
    private String status;
    

	public String suppTime = null;
	public String suppDate = null;
	public Time orderTime=null;

	public Delivery delivery =null;


	public Order(int OrderNumber,String store,String greetingCard,String Status,
			String price,String suppmethod,String suppTime,String suppDate,Time OrderTime)
	{
		this.orderNumber = OrderNumber;
		this.price = price;
		this.greetingCard =greetingCard;
		this.status = Status;
		this.SupplimentMethod = suppmethod;
		this.store = store;
		this.suppDate = suppDate;
		this.suppTime = suppTime;
		this.orderTime = OrderTime;
	}
	
	
	public Order(String greetingCard,String Status,
			String store,String ClientId,String suppTime,String suppDate,String suppmethod)
	{
		
		this.greetingCard =greetingCard;
		this.status = Status;
		this.SupplimentMethod = suppmethod;
		this.store = store;
		this.ClientId = ClientId;
		this.suppDate = suppDate;
		this.suppTime = suppTime;
	
	}

	
	public int getOrderNumber()
	{
		return orderNumber;	
	}
	
	public void setOrderNumber(int ordernumber)
	{
		orderNumber = ordernumber;
	}
	
	public String getPrice()
	{
		return price;
	}
	
	public void setPrice(String price)
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


	public String getSuppTime() {
		
		return this.suppTime.toString();
	}

	public String getSuppDate() {
		return this.suppDate.toString();
	}


	public Delivery getDelivery() {
		return delivery;
	}


	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
	
	public Time getOrderTime() {
		return orderTime;
	}
	
	public void setOrderTime(Time orderTime) {
		this.orderTime = orderTime;
	}
		
	}


