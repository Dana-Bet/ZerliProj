package Entities;

public class assembledItem {
        private int Quan;
        private float Price;
        private String Item_Name;

        public assembledItem(String name) {
        	this.Quan=0;
        	this.Price=0;
        	this.Item_Name = name; 
        
        }
        
        public void AddToQuan() {
        	Quan++;
        }
        public void DecToQuan() {
        	if(this.Quan>0) {
        	   Quan--;
        	}
        }
        public int getQuan() {
        	return Quan;
        }
        
        public float getPrice() {
        	return Price;
        }
        
        public void setPrice(float price) {
        	this.Price = price;
        }
        
        public String getName(){
        	return Item_Name;
        } 
        public float getTotalPrice() {
        	return this.Quan*this.Price;
        }
        
        
        public String toString() {
        	return  Quan + " " + Item_Name + " "+getTotalPrice()+ "$";
        }
}
