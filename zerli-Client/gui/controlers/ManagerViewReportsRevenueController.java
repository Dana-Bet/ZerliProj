package controlers;

import java.net.URL;
import java.util.ResourceBundle;

import Entities.Message;
import Entities.MessageType;
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
    private ComboBox<?> typeReportComboBox;

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
    
    String month,year;
    public static boolean ViewReportsRevenueFlag = false;
    @FXML
    void Month(ActionEvent event) {
    	month = monthComboBox.getValue();
    }
    @FXML
    void Year(ActionEvent event) {
    	year = yearComboBox.getValue();
    }
    @FXML
    void ShowRevenueReport(ActionEvent event) {
    	StringBuilder str=new StringBuilder();
    	str.append(month);
    	str.append("@");
    	str.append(year);
    	Message msg = new Message(MessageType.ShowRevenueReport,str.toString());
    	ClientUI.chat.accept(msg);
    }

    @FXML
    void beck(ActionEvent event) {

    }
    
	public void initialize(URL location, ResourceBundle resources) {
		ViewReportsRevenueFlag = true;	
	}
}
