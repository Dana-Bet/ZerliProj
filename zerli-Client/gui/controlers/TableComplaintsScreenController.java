package controlers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Entities.Complaint;
import Entities.Message;
import Entities.MessageType;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import main.ClientUI;

public class TableComplaintsScreenController extends AbstractController implements  Initializable{


    @FXML
    private TableView<Complaint> table;

    @FXML
    private TableColumn<Complaint, String> name;

    @FXML
    private TableColumn<Complaint, String> id;

    @FXML
    private TableColumn<Complaint, String> time;

    @FXML
    private TableColumn<Complaint, String> status;

    @FXML
    private TableColumn<Complaint, String> reason;


    @FXML
    private TextArea refundTxt;

    @FXML
    private ComboBox<String> chooseID;

    @FXML
    private Button confirm;
    @FXML
    private Label tableComplaintlbl;
    @FXML
    //private Button cliclBtn;

  
	public static ArrayList<String> listID = new ArrayList<String>();
	public static ArrayList<Complaint> listTable = new ArrayList<Complaint>();
	public static ArrayList<String> details = new ArrayList<String>();
	
	   @FXML
	    void UpdateRefund(ActionEvent event) {
		   details.add(chooseID.getValue());
		   details.add(refundTxt.getText());  
		   ClientUI.chat.accept(new Message(MessageType.setRefundToClient,details));
		   
	    }
	   
//	   @FXML
//	    void ShowTable(ActionEvent event) {
//	   }


	@Override
	public void display(String string) {
		//name.setText(LoginScreenController.user.getFirstN() + " " + LoginScreenController.user.getLastN());		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
			ClientUI.chat.accept(new Message(MessageType.getIdFromComplaitnDB,null));
			ObservableList<String> observableList2 = FXCollections.observableArrayList(listID);
			chooseID.setItems(observableList2);
			ClientUI.chat.accept(new Message(MessageType.ShowTableComlaintInDB,null));
	    	ObservableList<Complaint> observableList3 = FXCollections.observableArrayList(listTable);
	    	name.setCellValueFactory(new PropertyValueFactory<Complaint, String>("name"));
	    	id.setCellValueFactory(new PropertyValueFactory<Complaint, String>("id"));
	    	time.setCellValueFactory(new PropertyValueFactory<Complaint, String>("time"));
	    	status.setCellValueFactory(new PropertyValueFactory<Complaint, String>("status"));
	    	reason.setCellValueFactory(new PropertyValueFactory<Complaint, String>("reason"));
	    	table.setItems(observableList3);
	}
		
}
