package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import Entities.ClientCart;
import Entities.Item_In_Catalog;
import Entities.LineInCartTable;
import Entities.assembledProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class CartScreenController extends AbstractController implements Initializable {
	public static ClientCart cart;
	ArrayList<LineInCartTable> l ;
	ObservableList<LineInCartTable> observableList;
	
        @FXML
        private TableView<LineInCartTable> tableV;

		@FXML
		private ResourceBundle resources;

    	@FXML
    	private URL location;

        @FXML
        private Button BackBtn;

        @FXML
        private Button conBtn;

        @FXML
        private TableColumn<LineInCartTable,  Integer> ItemCol;

        @FXML
        private TableColumn<LineInCartTable,  Integer> QuanCol;

        @FXML
        private TableColumn<LineInCartTable,String> NameCol;

        @FXML
        private TableColumn<LineInCartTable, String> AssCol;

        @FXML
        private TableColumn<LineInCartTable, Float> PriceCol;
        
        @FXML
        private Label PriceLbl;
        

        @FXML
        private Button removeBtn;


        @FXML
        void removeFromProduct(ActionEvent event) {
            ObservableList<LineInCartTable> list;
            list = this.tableV.getSelectionModel().getSelectedItems();
            if(list!=null) {
            int id =list.get(0).getId() ;
            cart.DecFromCartTable(id);
            this.initialize(location, resources) ;
            }
        }

        public void UpdateCart(){
        	
	    	  if (!cart.Order_Components.isEmpty()) {
	    	       for(List<Item_In_Catalog> i : cart.Order_Components.values()) {
	    	    	  
	    	    		   if ( i.get(0) instanceof assembledProduct){
	    	    			   assembledProduct a = (assembledProduct) i.get(0);
	    	    			   l.add(new LineInCartTable(a.getId(), 1,a.getName(), "Assembled",a.getPrice()));
	    	    			   }
	    	    	       else {
	    	    	    	   Item_In_Catalog b = i.get(0);
	    	    	    	   l.add(new LineInCartTable(b.getId(),i.size() ,b.getName(), "Complete",b.getPrice()*i.size()));
	    	    		   }  
	    	    		 }  
	    	   } 
       }
        	  	
        
        @FXML
        void BackBtn(ActionEvent event) throws IOException {
        	start(event, "ClientCreateOrderScreen", "Create Order", "");
        }

        @FXML
        void ContinueToOrderPage(ActionEvent event) throws IOException {
        	start(event, "ClientOrderPage", "Order page", "");
        }
        
    	@Override
	    public void initialize(URL arg0, ResourceBundle arg1) {

    		this.l = new ArrayList<>();
    		UpdateCart();
    		ObservableList<LineInCartTable> observableList = FXCollections.observableArrayList(l);
    		tableV.getItems().clear();
    		ItemCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
    		QuanCol.setCellValueFactory(new PropertyValueFactory<>("Quan"));
    		NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
    	    AssCol.setCellValueFactory(new PropertyValueFactory<>("IsAss"));
    		PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
    		tableV.setItems(observableList);
    		PriceLbl.setText("Total price :"+cart.OrderTotalPrice().toString()+"$");
    		
	}

	    @Override
	    public void display(String string) {
	    
	}
    
	   public boolean isEmpty() {
		   return cart.Order_Components.isEmpty();
	}

}
	    	  
	          
