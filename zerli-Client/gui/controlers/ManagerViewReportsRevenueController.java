package controlers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.MessageType;
import Entities.Order;
import Entities.RevenueReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import main.ClientUI;

public class ManagerViewReportsRevenueController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> yearComboBox;

    @FXML
    private ComboBox<String> monthComboBox;

    @FXML
    private Button showReportBtn;

    @FXML
    private Label lblview;

    @FXML
    private Button backBtn;
    @FXML
    private TableColumn<RevenueReport, String> tableColumnamount;

    @FXML
    private TableColumn<RevenueReport, String> tableColumnincome;

    @FXML
    private TableColumn<RevenueReport, String> tableColumnquarterly;
   
    
    public static boolean ViewReportsRevenueFlag = false;
    private String[] month1 = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    public static ArrayList<RevenueReport> revenue= new ArrayList<>();

	public static ArrayList<String> years;
    
    @FXML
    void ShowRevenueReport(ActionEvent event) {
    	ClientUI.chat.accept(new Message(MessageType.ShowRevenueReport,null));
    	//eara
    }

    @FXML
    void beck(ActionEvent event) {

    }
 
    
    
	public void initialize(URL location, ResourceBundle resources) {
		ViewReportsRevenueFlag = true;	
		ClientUI.chat.accept(new Message(MessageType.getYear,null));
		ObservableList<String> observableList1 = FXCollections.observableArrayList(years);
		yearComboBox.setItems(observableList1);
		monthComboBox.getItems().addAll(month1);
		
	}
}
