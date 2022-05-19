package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.MessageType;
import Entities.assembledItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.ClientUI;

public class ClientAssemblyProductController extends AbstractController implements Initializable {
 

	public static boolean catalog_Initilaize = false ; 
	public static ArrayList<Item_In_Catalog> Catalog= new ArrayList<>();
	private RadioButton selectedRadioButton ;
	private String TypeOfProduct;
	//ArrayList<Item_In_Catalog> Order= new ArrayList<>();
	private float sum ;
	private Item_In_Catalog choosing_item;
	List<assembledItem> assembledProductlist;

	

	    @FXML
	    private Button BackBtn;

	    @FXML
	    private Button PlusBtn;

	    @FXML
	    private Label QuanLbl;

	    @FXML
	    private Label TotalPriceLbl;

	    @FXML
	    private Button AddToCartBtn;

	    @FXML
	    private ImageView productImage;

	    @FXML
	    private Label productNameLbl;
	    
	    @FXML
	    private Label updatelbl;

	    @FXML
	    private Label productPriceLbl;

	    @FXML
	    private Label productColorLbl;

	    @FXML
	    private ChoiceBox<String> listOfProducts;

	    @FXML
	    private TextArea ProductComponent;
	    
	    @FXML
	    private Label priceByQuan;

	    @FXML
	    private RadioButton FlowerPot;

	    @FXML
	    private ToggleGroup g1;

	    @FXML
	    private RadioButton Bouquet;

	    @FXML
	    private RadioButton Flowercluster;
	    
	    @FXML
	    private Button AddToProduct;


	    @FXML
	    void AddProductToCart(ActionEvent event) {
	    	
             }
             
    
	    
	    void UpdateTextFiled() {
	    	
	    	if(assembledProductlist!=null) {
                String inputText = ProductComponent.getText() + "\r\n" ; 
                ProductComponent.clear();
                int size = assembledProductlist.size();
                ProductComponent.appendText(inputText + assembledProductlist.get(size-1).toString() );
                this.sum+=assembledProductlist.get(size-1).getTotalPrice();    
	         }
              TotalPriceLbl.setText(Float.toString(sum));
	        }
	    
	    

	    @FXML
	    void AddQuan(ActionEvent event) {
	    	int flag = 0;
	    	if(assembledProductlist!=null) {
	    	 for(assembledItem i : assembledProductlist) {
	    		 if (i.getName().compareTo(choosing_item.getName())==0){
	    			 i.AddToQuan();
	    			 
	    			 calc_and_update_labels( i.getQuan() ,i.getTotalPrice() );
	    			 flag=1;
	    		 }
	    	 }
	    	}
	         if (flag==0) {
	        	 assembledItem j = new assembledItem(choosing_item.getName());
	        	 j.AddToQuan();
	        	 j.setPrice(choosing_item.getPrice());
	        	 
    			 calc_and_update_labels( j.getQuan() ,j.getTotalPrice() );
    			 
				 assembledProductlist.add(j);
	         } 
	       }	 
	    
	    
	    private void calc_and_update_labels (Integer q , Float t) {
	    	
	         QuanLbl.setText(q.toString());
	         priceByQuan.setText("price :"+t.toString());
	    	
	    }
	    

	    @FXML
	    void Back(ActionEvent event) throws IOException {
	    	start(event, "ClientCreateOrderScreen", "Create Order", "");
	    }

	    @FXML
	    void DecQuan(ActionEvent event) {
	    	 for(assembledItem i : assembledProductlist) {
	    		 if (i.getName().compareTo(choosing_item.getName())==0){
	    			 i.DecToQuan();
	    			 calc_and_update_labels( i.getQuan() ,i.getTotalPrice() );
	    			 if(i.getQuan()==0) {
	    				 assembledProductlist.remove(i);
	    			 }
	    			 
	    		 }
	    	 } 
	      
	    }
	    
	    
	    @FXML
	    void AddToProduct(ActionEvent event) {
	        QuanLbl.setText("");
	        priceByQuan.setText("");
	    	UpdateTextFiled();
	    }

	    @FXML
	    void getItemDetails(ActionEvent event) {
            productNameLbl.setText("");
            productPriceLbl.setText("");
            productColorLbl.setText("");
            this.productImage.setImage(null);
   
    	try {
              String Choosing_Item = listOfProducts.getValue();
              for (Item_In_Catalog i : Catalog) {
              	if (i.getName().compareTo(Choosing_Item)==0){
              		choosing_item = new Item_In_Catalog(i.getId(), i.getColor(), i.getName(),
        				   i.getType(), i.getPrice(), i.isAssembleItem());
        		     break;
        	}
        }
	     	
	              productNameLbl.setText(choosing_item.getName());
	              productPriceLbl.setText("Price :"+(choosing_item.getPrice()).toString()+" $");
	              productColorLbl.setText("Dominant color : "+(choosing_item.getColor()).toString());
	              Image im= new Image("/images/"+choosing_item.getName()+".JPG");
	              this.productImage.setImage(im);
	        
	             }catch(Exception e) {}
    	
	    }
	    
	    @FXML
	    void getProductType(ActionEvent event) {
	    	setSelection();
			selectedRadioButton = (RadioButton) g1.getSelectedToggle();
			TypeOfProduct = selectedRadioButton.getText();
	    }
	    
	    private void setSelection() {
	    	sum = 0; 
	    	assembledProductlist.clear();
	        QuanLbl.setText("");
	        priceByQuan.setText("");
	        ProductComponent.clear();
	    }
	     
    
	    @Override
	    public void display(String string) {
		 	// TODO Auto-generated method stub
			
	 	}

    	@Override
    	public void initialize(URL arg0, ResourceBundle arg1) {
			ClientUI.chat.accept(new Message(MessageType.Initialize_Catalog,"1"));
			
			this.sum = 0 ;
			this.choosing_item = null;
			this.assembledProductlist = new ArrayList<>();
			
			FlowerPot.setUserData("FlowerPot");
			FlowerPot.setToggleGroup(g1);
			FlowerPot.setSelected(false);
			Bouquet.setUserData("Bouquet");
			Bouquet.setToggleGroup(g1);
			Bouquet.setSelected(true);
			Flowercluster.setUserData("Flower cluster");
			Flowercluster.setToggleGroup(g1);
			Flowercluster.setSelected(false);


			selectedRadioButton = (RadioButton) g1.getSelectedToggle();
			TypeOfProduct = selectedRadioButton.getText();
			
	    	listOfProducts.setValue("choose product from list");
	    	listOfProducts.getItems().clear();
	    	ArrayList<String> Items =  new ArrayList<String>();
	    	for (Item_In_Catalog i : Catalog) {
	    			Items.add(i.getName());
	    			System.out.println(i.getName());
	    		}	
	    	
	    	listOfProducts.getItems().addAll(Items);
	    	listOfProducts.setValue("eucalyptus branch");
		}
        	
	}

