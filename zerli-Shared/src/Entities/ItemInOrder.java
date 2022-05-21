package Entities;

public class ItemInOrder extends Item_In_Catalog{
        private int Quan=0;
    	private static final long serialVersionUID = 1L;
    	
        public ItemInOrder(int id ,String color, String name, String type, Float price, String assembleItem,int Quan) {
        	super(id ,color, name,type,price, assembleItem);
        	this.Quan=Quan;
        }
        
        public void AddToQuan() {
        	this.Quan+=1;
        }
        
        public void setQuan(int q) {
        	this.Quan=q;
        }
        
        public void DecToQuan() {
        	if(this.Quan>0) {
        		this.Quan-=1;
        	}
        }
        public Integer getQuan() {
        	return this.Quan;
        }
        
        public Float getTotalPrice() {
        	return this.Quan*this.getPrice();
        }
        
        
        public String toString() {

        	return this.Quan + " " +this.getName()+ " "+getTotalPrice()+ "$";
        }
}
