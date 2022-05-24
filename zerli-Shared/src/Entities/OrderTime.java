package Entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderTime {
	int day ;
	int month ; 
	int hour;
	LocalTime currenthour ; 
	LocalDate currentDate ;
	
	public OrderTime( ){
		LocalTime currenthour  =  LocalTime.now();
		LocalDate currentDate =  LocalDate.now();
		this.day = currentDate.getDayOfMonth();
		this.month = currentDate.getMonthValue();
		this.hour =	currenthour.getHour();	
   }

				
	public OrderTime(LocalTime t , LocalDate d  ){
		LocalTime currenthour  =  t;
		LocalDate currentDate =  d;
		this.day = currentDate.getDayOfMonth();
		this.month = currentDate.getMonthValue();
		this.hour =	currenthour.getHour();	
   }

   public String toString() {
	   return currentDate.toString() + " "+currenthour.toString();
   }
}