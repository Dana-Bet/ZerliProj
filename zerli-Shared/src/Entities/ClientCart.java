package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientCart<T extends Item_In_Catalog> {
	      public Map<Integer,T> Order_Components;
	      public Float totalPrice;
	   
		public ClientCart () {
	    	  this.Order_Components =new HashMap<>(); 
	    	  this.totalPrice  = (float) 0;
	      }
		
		public void AddToCart(T i) {
            
			if(i instanceof assembledProduct)
			{
				Order_Components.put(i.getId(),i);
			}
			else {
				if(Order_Components.containsKey(i.getId())) { //if exist
					int q=((ItemInOrder)i).getQuan();
					((ItemInOrder)Order_Components.get(i.getId())).setQuan(q);
				}
					else {
						Order_Components.put(i.getId(),i);
						int q=((ItemInOrder)i).getQuan();
						((ItemInOrder)Order_Components.get(i.getId())).setQuan(q);
						
				}
    	}
	}

		
	      
	    public float OrderTotalPrice() {
	    	  float price = 0;
	    	  if (Order_Components!=null) {
	    	       for(Item_In_Catalog i : Order_Components.values()) {
	    	    		   price += i.getPrice();
	    	     }
	    	  }
			return price;
	      }
	      
	      public ArrayList<String> Create_Recipt() {
	    	  ArrayList<String> Recipt = new ArrayList<>();
	    	  if (Order_Components!=null) {
	    	       for(Item_In_Catalog i : Order_Components.values()) {
	    	    	  if (i instanceof assembledProduct) {
	    	    		  i = (assembledProduct)i;
	    	    	  }
	    	    	  else {
	    	    	  i = (ItemInOrder)i; 
	    	    	  }
	    	    	  Recipt.add(new String(i.toString()));
	    	     }
	      }
			  return Recipt;
          
	}
	      
	      public Integer getNumberOfItems() {
	    	 int cnt = new Integer(0);
	    	 if (Order_Components!=null) {
	    	       for(Item_In_Catalog i : Order_Components.values()) {
	    	    	   if(Order_Components.get(i.getId()) instanceof assembledProduct)
	    				{
	    					cnt+=1;
	    				}
	    	    	   else {
	    	    		    cnt+=((ItemInOrder)i).getQuan();
	    	    	   }
	    	        }
	    	  }
			return cnt; 
	      }
	         
}



