package Entities;

import java.util.HashMap;
import java.util.Map;

public class assembledProduct extends Item_In_Catalog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Map<Integer,assembledItem> Product_components_map = null;

	
	public assembledProduct(int id, String name, String type, String assembleItem) {
		super(id, name, type, assembleItem);
		this.Product_components_map = new HashMap<Integer,assembledItem>(); 
	}
	

	
	@Override
	public Float getPrice() {
		float price = 0;
		if(!this.Product_components_map.isEmpty()) {
		        for (assembledItem Val: Product_components_map.values()) {
			         price += Val.getTotalPrice();
		        }
		}
		return price;
	}
    
	public int Get_size() {
		if(Product_components_map!=null) {
	        return Product_components_map.size();
	        }
		else return 0;
	}
	
    @SuppressWarnings("null")
	@Override
	public String toString() {
		StringBuilder Items_in_Product = new StringBuilder();
		Items_in_Product.append(this.getType());
		if(!this.Product_components_map.isEmpty()) {
			 for (assembledItem Val: Product_components_map.values()) {
	        	 Items_in_Product.append("\n  +");
	        	 Items_in_Product.append(Val.toString());
	        }

         }
		return Items_in_Product.toString();
	}
    
    
    public void addToProduct(assembledItem i) {
    	if (!this.Product_components_map.isEmpty()) {
    		if(this.Product_components_map.containsKey(i.getId())) {
    			Product_components_map.get(i.getId()).AddToQuan();
    			return;
    		}
    	}
		assembledItem temp = new assembledItem(i.getId(), i.getColor(), i.getName(),
  				   i.getType(), i.getPrice(), i.isAssembleItem());
 		Product_components_map.put(i.getId(),temp);
    
    		
    }

    	
    
    public void DecFromProduct(assembledItem i) {
    	if (!this.Product_components_map.isEmpty()) {
    		if(this.Product_components_map.containsKey(i.getId())) {
    			Product_components_map.get(i.getId()).DecToQuan();
    			if(Product_components_map.get(i.getId()).getQuan()==0)
    			{
    				Product_components_map.remove(i.getId());
    			}
    			return;
    		}
    }

    	
    
}
    
    
}
