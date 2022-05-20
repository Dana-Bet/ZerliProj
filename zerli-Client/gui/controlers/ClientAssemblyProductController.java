package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.MessageType;
import Entities.assembledItem;
import Entities.assembledProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.ClientUI;

public class ClientAssemblyProductController extends AbstractController implements Initializable {
 
    private assembledProduct AProduct;
	public static boolean catalog_Initilaize = false ; 
	public static ArrayList<Item_In_Catalog> Catalog= new ArrayList<>();
	private RadioButton selectedRadioButton ;
	private String TypeOfProduct;
	private assembledItem item;
	private Item_In_Catalog choosing_Type;

	

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
	    	ProductComponent.setText(AProduct.toString());
	    	TotalPriceLbl.setText("Price : "+AProduct.getPrice().toString()+"$");
	        }
	    
	    

	    @FXML
	    void AddQuan(ActionEvent event) {
	    	if (choosing_Type==null) {
	    		updatelbl.setText("Please choose Product Type!");
	    		return;
	    	}
	    	AProduct.addToProduct(this.item);
	    	priceByQuan.setText("Price : "+AProduct.Product_components_map.get(item.getId()).getTotalPrice().toString()+"$");
	    	QuanLbl.setText(AProduct.Product_components_map.get(item.getId()).getQuan().toString());
	       }	 
	    

	    @FXML
	    void Back(ActionEvent event) throws IOException {
	    	start(event, "ClientCreateOrderScreen", "Create Order", "");
	    }

	    @FXML
	    void DecQuan(ActionEvent event) {
	    	if (choosing_Type==null) {
	    		updatelbl.setText("Please choose Product Type!");
	    		return;
	    	}
	    	AProduct.DecFromProduct(this.item);
	    	if(AProduct.Product_components_map.containsKey(item.getId())) {
	    	         priceByQuan.setText("Price : "+AProduct.Product_components_map.get(item.getId()).getTotalPrice().toString()+"$");
	    	         QuanLbl.setText(AProduct.Product_components_map.get(item.getId()).getQuan().toString());
	    }
	    	else {
		    	priceByQuan.setText("Price :");
		    	QuanLbl.setText("0");
	    	}
	    }
	    
	    
	    @FXML
	    void AddToProduct(ActionEvent event) {
	    	if(QuanLbl.getText().compareTo("0")==0)
	    		return;
	    	TotalPriceLbl.setText("Price : "+AProduct.getPrice().toString()+"$");
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
              		 this.item = new assembledItem(i.getId(), i.getColor(), i.getName(),
        				   i.getType(), i.getPrice(), i.isAssembleItem());
        		     break;
        	}
        }
	     	
	              productNameLbl.setText(this.item.getName());
	              productPriceLbl.setText("Price :"+(this.item.getPrice()).toString()+" $");
	              productColorLbl.setText("Dominant color : "+(this.item.getColor()).toString());
	              Image im= new Image("/images/"+this.item.getName()+".JPG");
	              this.productImage.setImage(im);
	        
	             }catch(Exception e) {}
    	
	    }
	    
	    
	    @FXML
	    void getProductType(ActionEvent event) {
	    	this.AProduct=null;
	    	ProductComponent.clear();
	    	setSelection();
			selectedRadioButton = (RadioButton) g1.getSelectedToggle();
			TypeOfProduct = selectedRadioButton.getText();
       
            for (Item_In_Catalog i : Catalog) {
            	if (i.getType().compareTo(TypeOfProduct)==0){
            		this.choosing_Type = new Item_In_Catalog(i.getId(), i.getName(),
      				   i.getType(), i.isAssembleItem());
      		        break;
      	        }
	    }
            this.AProduct = new assembledProduct(choosing_Type.getId(),choosing_Type.getName(),choosing_Type.getType(),choosing_Type.isAssembleItem());
	    }
	    
	    private void setSelection() {
	    	updatelbl.setText("");
			this.TotalPriceLbl.setText("");
	    	priceByQuan.setText("");
	    	QuanLbl.setText("");
	    }
	     
    
	    @Override
	    public void display(String string) {
		 	// TODO Auto-generated method stub
			
	 	}

    	@Override
    	public void initialize(URL arg0, ResourceBundle arg1) {
			ClientUI.chat.accept(new Message(MessageType.Initialize_Catalog,"1"));
			this.AProduct=null;
			this.item = null;
	    	

			FlowerPot.setUserData("Flower Pot");
			FlowerPot.setToggleGroup(g1);
		//	FlowerPot.setSelected(false);
			Bouquet.setUserData("Bouquet");
			Bouquet.setToggleGroup(g1);
		//	Bouquet.setSelected(false);
			Flowercluster.setUserData("Flower cluster");
			Flowercluster.setToggleGroup(g1);
		//	updatelbl.setText("Please choose Product Type!");
			
	    	listOfProducts.setValue("choose product from list");
	    	listOfProducts.getItems().clear();
	    	ArrayList<String> Items =  new ArrayList<String>();
	    	for (Item_In_Catalog i : Catalog) {
	    		if(i.getPrice()!=0) {
	    			Items.add(i.getName());
	    			System.out.println(i.getName());
	    		}	
	    	}
	    	listOfProducts.getItems().addAll(Items);
	    	listOfProducts.setValue("eucalyptus branch");
	    	
		}
        	
	}

