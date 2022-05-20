package Entities;

import java.util.ArrayList;

public class ClientCart {
	      public ArrayList<Item_In_Catalog> Order_Components = null ;
	      public Float totalPrice;
	   
		public ClientCart () {
	    	  this.Order_Components = new ArrayList<>() ;
	    	  this.totalPrice  = (float) 0;
	      }
	      
	      public float OrderTotalPrice() {
	    	  float price = 0;
	    	  if (Order_Components!=null) {
	    	       for(Item_In_Catalog i : Order_Components) {
	    	    		   price += i.getPrice();
	    	     }
	    	  }
			return price;
	      }
	      
	      public ArrayList<String> Create_Recipt() {
	    	  ArrayList<String> Recipt = new ArrayList<>();
	    	  if (Order_Components!=null) {
	    	       for(Item_In_Catalog i : Order_Components) {
	    	    	  if (i instanceof assembledProduct) {
	    	    		  i = (assembledProduct)i;
	    	    	  }
	    	    	  Recipt.add(i.toString());  
	    	     }
	      }
			  return Recipt;
          
	}
}



