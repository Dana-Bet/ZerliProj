/**
 * Sample Skeleton for 'ShowUpdate.fxml' Controller Class
 */

package controlers;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.ClientUI;

public class ShowUpdateController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="showBtn"
    private Button showBtn; // Value injected by FXMLLoader

    @FXML // fx:id="updateBtn"
    private Button updateBtn; // Value injected by FXMLLoader

    @FXML // fx:id="CloseBtn"
    private Button CloseBtn; // Value injected by FXMLLoader
    
    @FXML
    void showOrders(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	Message msg = new Message(MessageType.Show_Orders,null);
    	ClientUI.chat.accept(msg);
    	((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		Pane root = loader.load(getClass().getResource("/fxml/ShowForm.fxml").openStream());
		ShowFormController showFormController  = loader.getController();		
		showFormController.initialize(showFormController.getLocation(), showFormController.getResources());
		Scene scene = new Scene(root);			
		primaryStage.setTitle("Show Form");
		primaryStage.setScene(scene);	
		primaryStage.getIcons().add(new Image("/fxml/zerLiIcon.png"));
		primaryStage.show();
    }

    @FXML
    void updateOrders(ActionEvent event) throws IOException 
    {
		FXMLLoader loader = new FXMLLoader();
		((Node) event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Pane root = loader.load(getClass().getResource("/fxml/UpdateForm.fxml").openStream());
		Scene scene = new Scene(root);			
		primaryStage.setTitle("Update window");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("/fxml/zerLiIcon.png"));
		primaryStage.show();
    }
    
	public void Close(ActionEvent event) {
		Stage stage = (Stage) CloseBtn.getScene().getWindow();
	    stage.close();
		Message msg = new Message(MessageType.Disconected,null);
    	ClientUI.chat.accept(msg);
	}

    @FXML
    void initialize() {
    	assert showBtn != null : "fx:id=\"showBtn\" was not injected: check your FXML file 'ShowUpdate.fxml'.";
        assert updateBtn != null : "fx:id=\"updateBtn\" was not injected: check your FXML file 'ShowUpdate.fxml'.";
        assert CloseBtn != null : "fx:id=\"CloseBtn\" was not injected: check your FXML file 'ShowUpdate.fxml'.";
    }
  
	public void start(Stage primaryStage) throws IOException 
	{
		primaryStage.setTitle("ZerLi");
		Parent root=FXMLLoader.load(getClass().getResource("/fxml/ShowUpdate.fxml"));
		Scene home=new Scene(root);
		primaryStage.setScene(home);
		primaryStage.getIcons().add(new Image("/fxml/zerLiIcon.png"));
		primaryStage.show();
	}

}