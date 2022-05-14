package controlers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Entities.Message;
import Entities.MessageType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.ChatClient;

public class UpdateFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backBtn;

    @FXML
    private Button fUpdateBtn;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblType;
    
    @FXML
    private Label updateLbl;

    @FXML
    private TextField txtColor; 

    @FXML
    private DatePicker txtDate;
    

    @FXML
    private TextField txtOrderNumber;
    
    public static boolean flagUpdate=false;

    @FXML
    void back(ActionEvent event) throws IOException 
    {
    	((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/ShowUpdate.fxml"));
		Scene scene = new Scene(root);		
		primaryStage.setTitle("ZerLi");
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void sendDataUpdate(ActionEvent event)
    {
		FXMLLoader loader = new FXMLLoader();
		LocalDate temp = txtDate.getValue();
		if(txtColor.getText().trim().isEmpty()|| txtOrderNumber.getText().trim().isEmpty() || temp == null)
		{
			System.out.println("In order to update you must enter all fields");	
		}
		StringBuilder str=new StringBuilder();
		str.append(txtOrderNumber.getText());
		str.append("@");
		str.append(txtColor.getText());
		str.append("@");
		str.append(txtDate.getValue());
		
		Message msg = new Message(MessageType.Update_Orders,str.toString());
		ChatClient.chatClient.handleMessageFromClientUI(msg);
		
		if(flagUpdate==true)
		{
			updateLbl.setText("Update Successed!");	
			flagUpdate=false;
		}
		else
		{
			updateLbl.setText("The order is not exist!");
		}

    }
    
}

