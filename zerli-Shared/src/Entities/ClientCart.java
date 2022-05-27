package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientCart {
	      public Map<Integer,List <Item_In_Catalog>> Order_Components;
	      public Float totalPrice;
	      private int NumberOfItems;
	   
		public ClientCart () {
	    	  this.Order_Components =new HashMap<Integer , List <Item_In_Catalog>>(); 
	    	  this.totalPrice  = (float) 0;
	    	  this. NumberOfItems = 0;
	      }
		
		public void AddToCart(Item_In_Catalog i) {
            
			if(i instanceof assembledProduct)
			{
				  i=(assembledProduct)i;
			}
			
			if (Order_Components.containsKey(i.getId())) { 
		        if(Order_Components.get(i.getId())!=null) {
			     	Order_Components.get(i.getId()).add(i);
		        }
		        else {
					Order_Components.replace(i.getId(),new ArrayList<Item_In_Catalog>());
					Order_Components.get(i.getId()).add(i);
		        }
		     }
			else {
				Order_Components.put(i.getId(), new ArrayList<Item_In_Catalog>());
				Order_Components.get(i.getId()).add(i);
				}	
			NumberOfItems+=1;
			
	}

		public void DecFromCart(Item_In_Catalog i) {
            
			if(i instanceof assembledProduct)
			{
				  i=(assembledProduct)i;
			}
			
			if (Order_Components.containsKey(i.getId())) { 
		        if(!Order_Components.get(i.getId()).isEmpty() && Order_Components.get(i.getId())!=null) {
			     	Order_Components.get(i.getId()).remove(0);
			     	NumberOfItems--;
			     	if (Order_Components.get(i.getId()).isEmpty()){
			     		Order_Components.remove(i.getId());
			     	}
		        }
	       }
			
		}
		
		public void DecFromCartTable(int id) {

			if (Order_Components.containsKey(id)) { 
		        if(!Order_Components.get(id).isEmpty() && Order_Components.get(id)!=null) {
			     	Order_Components.get(id).remove(0);
			     	NumberOfItems--;
			     	if (Order_Components.get(id).isEmpty()){
			     		Order_Components.remove(id);
			     	}
		        }
	       }
			
		}
		
	      
	     public Float OrderTotalPrice() {
	    	  this.totalPrice = new Float(0);
	    	  if (Order_Components!=null) {
	    	       for(List<Item_In_Catalog> i : Order_Components.values()) {
	    	    	   for(Item_In_Catalog j : i) {
	    	    		   this.totalPrice +=j.getPrice();
	    	    		   
	    	    	   }
	    	     }
	    	  }
			return totalPrice;
	      }

	      
	      public Integer getNumberOfItems() {
			return this.NumberOfItems; 
	      }
	      
	      public void setNumberOfItems() {
			this.NumberOfItems=0; 
	      }
	      
	      public Integer getQuanOfProInCart(int id) {
	    	  List<Item_In_Catalog> ListOfSpecificProduct= this.Order_Components.get(id) ;
	    	  if (ListOfSpecificProduct!=null) {
	    		  return ListOfSpecificProduct.size();
	    		  
	    	  }
	    	  return 0 ;
	      }
	         
	      
	      public Float getTotalPrice(int id) {
	    	  List<Item_In_Catalog> ListOfSpecificProduct= this.Order_Components.get(id) ;
	    	  if (ListOfSpecificProduct!=null) {
	    		  float pricePerOne = ListOfSpecificProduct.get(0).getPrice();
	    		  return pricePerOne*ListOfSpecificProduct.size();
	    		  
	    	  }
	    	  return (float) 0 ;
	      }
	         
}



