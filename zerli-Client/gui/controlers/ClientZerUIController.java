package controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.ClientController;
import main.ClientUI;
//import main.PopUpMessage;
//import main.PopUpMessage;

	public class ClientZerUIController extends AbstractController{
	
		//public static Stage mainStage;
		//public static ClientController chat;
		//public static ShowUpdateController ShowUpdateController;

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button ConnectBtn;

	    @FXML
	    private TextField ipTxt;
	    
	    @FXML
		void ConnectToServer(ActionEvent event) throws IOException {
			String ip;
			if (ipTxt.getText().isEmpty()) {
				//PopUpMessage.errorMessage("you must enter an ip!");
			} else {
				ip = ipTxt.getText().toString();
				ClientUI.chat = new ClientController(ip, 5555);
				start(event, "LoginUserScreen", "", "");
			}
		}
	    
	    public void start(Stage primaryStage) throws Exception {
			primaryStage.setTitle("ZerLi");
			Parent root=FXMLLoader.load(getClass().getResource("/fxml/ClientMainUI.fxml"));
			Scene home=new Scene(root);
			primaryStage.setScene(home);
			primaryStage.getIcons().add(new Image("/fxml/zerLiIcon.png"));
			primaryStage.show();
		}
	    
		@Override
		public void display(String string) {

		}

}
