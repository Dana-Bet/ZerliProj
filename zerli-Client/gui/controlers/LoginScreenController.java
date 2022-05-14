package controlers;

import java.net.URL;
import java.util.ResourceBundle;

import Entities.Message;
import Entities.MessageType;
import Entities.User;
import interfaces.ILoginInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.ClientUI;

  public class LoginScreenController extends AbstractController { 
	  
		public static User user = null;
		public ILoginInterface iLogin;
		public static String statusUser;
		
		public LoginScreenController() {
			iLogin = new LoginInterface(); // for real use
		}

		public LoginScreenController(ILoginInterface iLogin) {
			this.iLogin = iLogin;
		}

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button LoginBtn;

	    @FXML
	    private TextField usernameTxt;
	    
	    @FXML
	    private TextField passwordTxt;
	    
	    @FXML
	    private Label updateLbl;
	    

		public class LoginInterface implements ILoginInterface {

			public LoginInterface() {

			}

			public ILoginInterface getInterFace() {
				return this;
			}

			@Override
			public void setUser(String role, String id, String firstN, String lastN, String userName,String password, String isLoggedIn) {
			}

			
			@Override
			public void ConnectSystem(ActionEvent event) throws Exception {
				if (usernameTxt.getText().isEmpty() || passwordTxt.getText().isEmpty()) {
					updateLbl.setText("Please fill both user name and password");
				} else {
					StringBuilder str = new StringBuilder();
					str.append(usernameTxt.getText());
					str.append("@");
					str.append(passwordTxt.getText());
					ClientUI.chat.accept(new Message(MessageType.userlogin, str.toString())); 
					
					if (!statusUser.equals("Active")) {
						updateLbl.setText(statusUser);
						statusUser = null;
					}
				}
				if (user != null) {
				  switch (user.getRole()) {
					case "BranchManager": {
						start(event, "BranchManagerScreen", "Branch Manager", user.getFirstN());
						break;
					}

					case "Customer": {
						System.out.println("working!");
						start(event, "ClientMainPage", "Customer Screen", user.getFirstN());
						break;
					}

					case "CEO": {
						start(event, "CEOScreen", "CEO", user.getFirstN());
						break;

					}
					case "CustomerEmployee": {
						start(event, "CustomerEmployeeScreen", "CustomerEmployee", user.getFirstN());
						break;

				    }
					case "ServiceSpecialist": {
						start(event, "ServiceSpecialistScreen", "ServiceSpecialist", user.getFirstN());
						break;

					}
				  }
				}		
			}

			@Override
			public User getUser() {
				return user;
			}

			@Override
			public void setStatus(String status) {
				statusUser = status;
			}

			@Override
			public String getStatus() {
				return statusUser;
			}

		}
		
		@FXML
		public void ConnectSystem(ActionEvent event) throws Exception {
			iLogin.ConnectSystem(event); // get true in good login scenario or get false if login failed!
		}


		@Override
		public void display(String string) {
			// TODO Auto-generated method stub
			
		}


			
 }
