package Entities;

public class assembledItem extends Item_In_Catalog{
        private int Quan;
    	private static final long serialVersionUID = 1L;
    	
        public assembledItem(int id ,String color, String name, String type, Float price, String assembleItem) {
        	super(id ,color, name,type,price, assembleItem);
        	this.Quan=0;
        }
        
        public void AddToQuan() {
        	Quan+=1;
        }
        public void DecToQuan() {
        	if(this.Quan>0) {
        	   Quan-=1;
        	}
        }
        public Integer getQuan() {
        	return this.Quan;
        }
        
        public Float getTotalPrice() {
        	return this.Quan*this.getPrice();
        }
        
        
        public String toString() {
        	return  Quan + " " +this.getName()+ " "+getTotalPrice()+ "$";
        }
}
