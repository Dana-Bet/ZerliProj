package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.MessageType;
import Entities.OrdersReport;
import Entities.RevenueReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.ClientUI;

public class ManagerViewReportsOrders extends AbstractController implements Initializable{

		@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button backBtn;

	    @FXML
	    private ComboBox<String> productTypeBtn;

	    @FXML
	    private Button showOradersBtn;
	    
	    @FXML
	    private TableView<OrdersReport> table;

	    @FXML
	    private TableColumn<OrdersReport, String> monthcol;

	    @FXML
	    private TableColumn<OrdersReport, String> yearcol;

	    @FXML
	    private TableColumn<OrdersReport, String> storecol;

	    @FXML
	    private TableColumn<OrdersReport, String> Quantitycol;

	    
	    public static ArrayList<String> productType = new ArrayList<String>();
	    public static String type;

		public static ArrayList<OrdersReport> productTypeOrders =  new ArrayList<OrdersReport>();
	    @FXML
	    void ShowOrdersReport(ActionEvent event) {
	    	type = productTypeBtn.getValue();
	    	ClientUI.chat.accept(new Message(MessageType.getTypeOrders,type));
	    	ObservableList<OrdersReport> observableList3 = FXCollections.observableArrayList(productTypeOrders);
	    	monthcol.setCellValueFactory(new PropertyValueFactory<OrdersReport, String>("month"));
	    	yearcol.setCellValueFactory(new PropertyValueFactory<OrdersReport, String>("year"));
	    	storecol.setCellValueFactory(new PropertyValueFactory<OrdersReport, String>("store"));
	    	Quantitycol.setCellValueFactory(new PropertyValueFactory<OrdersReport, String>("Quantity"));
	    	//System.out.println(productTypeOrders);
	    	table.setItems(observableList3);
	    	
	    }
	    
	    @FXML
		void back(ActionEvent event) throws IOException {
			start(event,"MainManagerScreen","Branch Manager", LoginScreenController.user.getFirstN());
		}
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ClientUI.chat.accept(new Message(MessageType.getTypeProduct,null));
		ObservableList<String> observableList1 = FXCollections.observableArrayList(productType);
		productTypeBtn.setItems(observableList1);
	}

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}

}
