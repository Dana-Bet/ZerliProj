package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Entities.Client;
import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.MessageType;
import Entities.Order;
import Entities.RevenueReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.ClientUI;

public class ManagerViewReportsRevenueController extends AbstractController implements Initializable{
//////earacccc/////ffff
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<RevenueReport> table;
    
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
    private TableColumn<RevenueReport, String> tableColumnordersAmount;

    @FXML
    private TableColumn<RevenueReport, String> tableColumnincome;

    @FXML
    private TableColumn<RevenueReport, String> tableColumnquarterly;
   
    public static boolean ViewReportsRevenueFlag = false;
    public static ArrayList<RevenueReport> revenue= new ArrayList<RevenueReport>();
	public static ArrayList<String> years;
	public static ArrayList<String> months;
	public static ArrayList<String> details = new ArrayList<String>();
    @FXML
    void ShowRevenueReport(ActionEvent event) {
    	details.add(LoginScreenController.user.getId());
    	details.add(yearComboBox.getValue());                                     
    	details.add(monthComboBox.getValue());
    	ClientUI.chat.accept(new Message(MessageType.getRevenueReports,details));
    	ObservableList<RevenueReport> observableList3 = FXCollections.observableArrayList(revenue);
    	tableColumnincome.setCellValueFactory(new PropertyValueFactory<RevenueReport, String>("income"));
    	tableColumnquarterly.setCellValueFactory(new PropertyValueFactory<RevenueReport, String>("Quarterly"));
    	tableColumnordersAmount.setCellValueFactory(new PropertyValueFactory<RevenueReport, String>("ordersamount"));
    	System.out.println(revenue);
    	table.setItems(observableList3);
    	
    }

	@FXML
	void back(ActionEvent event) throws IOException {
		start(event,"MainManagerScreen","Branch Manager", LoginScreenController.user.getFirstN());
	}
 
    ////ksksksnnnnn
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ViewReportsRevenueFlag = false;
		ClientUI.chat.accept(new Message(MessageType.getYear,null));
		ObservableList<String> observableList1 = FXCollections.observableArrayList(years);
		yearComboBox.setItems(observableList1);
		ClientUI.chat.accept(new Message(MessageType.getMonth,null));
		ObservableList<String> observableList2 = FXCollections.observableArrayList(months);
		monthComboBox.setItems(observableList2);
	}

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}
}
