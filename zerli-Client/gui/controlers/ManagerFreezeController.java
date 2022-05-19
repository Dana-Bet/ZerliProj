package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Entities.Message;
import Entities.MessageType;
import Entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import main.ClientUI;

public class ManagerFreezeController extends AbstractController implements  Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label chooseCustomer;

    @FXML
    private ComboBox<String> customerName;

    @FXML
    private Button freezeBtn;

    @FXML
    private Button backBtn;
    @FXML
    private ComboBox<String> homeStroeBtn;
    @FXML
    private Button storeBtn;
    
    public static ArrayList<String> customerList;
    public static ArrayList<String> homeStoreList;
    String customer;

    @FXML
    void chooseStore(ActionEvent event) {
    	String store = homeStroeBtn.getValue();
		ClientUI.chat.accept(new Message(MessageType.getCustomerToFreeze,store));
		ObservableList<String> observableList1 = FXCollections.observableArrayList(customerList);
		customerName.setItems(observableList1);
    }
    @FXML
    void Freeze(ActionEvent event) {
    		customer = customerName.getValue();
    		ClientUI.chat.accept(new Message(MessageType.customerFreeze,customer));
    }
    @FXML
		void back(ActionEvent event) throws IOException {
			start(event,"MainManagerScreen","Branch Manager", LoginScreenController.user.getFirstN());
		}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ClientUI.chat.accept(new Message(MessageType.getHomeStore,null));
		ObservableList<String> observableList2 = FXCollections.observableArrayList(homeStoreList);
		homeStroeBtn.setItems(observableList2);
	}

	@Override
	public void display(String string) {
		// TODO Auto-generated method stub
		
	}

}
