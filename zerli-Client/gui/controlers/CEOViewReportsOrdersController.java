package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Entities.Message;
import Entities.MessageType;
import Entities.OrdersReport;
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

public class CEOViewReportsOrdersController extends AbstractController implements  Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> storeBtn;

    @FXML
    private ComboBox<String> typeBtn;


    @FXML
    private TableView<OrdersReport> table;

    @FXML
    private TableColumn<OrdersReport,String> monthcol;

    @FXML
    private TableColumn<OrdersReport,String> yearcol;

    @FXML
    private TableColumn<OrdersReport,String> storecol;

    @FXML
    private TableColumn<OrdersReport,String> Quantitycol;

    @FXML
    private TableColumn<OrdersReport,String> typecol;

    @FXML
    private Button showBtn;

   
    public static ArrayList<String> types = new ArrayList<String>();
    public static ArrayList<String> stores = new ArrayList<String>();
    public static ArrayList<String> details = new ArrayList<String>();
    public static ArrayList<OrdersReport> reports = new ArrayList<OrdersReport>();
    
    @FXML
    void ShowReport(ActionEvent event) throws IOException {
    	details.add(storeBtn.getValue());
    	details.add(typeBtn.getValue());
     	ClientUI.chat.accept(new Message(MessageType.getCEOordersReport,details));
    	ObservableList<OrdersReport> observableList = FXCollections.observableArrayList(reports);
    	monthcol.setCellValueFactory(new PropertyValueFactory<OrdersReport, String>("month"));
    	yearcol.setCellValueFactory(new PropertyValueFactory<OrdersReport, String>("year"));
    	storecol.setCellValueFactory(new PropertyValueFactory<OrdersReport, String>("store"));
    	Quantitycol.setCellValueFactory(new PropertyValueFactory<OrdersReport, String>("Quantity"));
    	typecol.setCellValueFactory(new PropertyValueFactory<OrdersReport, String>("type"));
    	System.out.println(details);
    	table.setItems(observableList);
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ClientUI.chat.accept(new Message(MessageType.getStoresForCEOordersReports,null));
		ObservableList<String> observableList3 = FXCollections.observableArrayList(stores);
		storeBtn.setItems(observableList3);
		ClientUI.chat.accept(new Message(MessageType.getTypesForCEOordersReports,null));
		ObservableList<String> observableList2 = FXCollections.observableArrayList(types);
		typeBtn.setItems(observableList2);
	}

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}

}
