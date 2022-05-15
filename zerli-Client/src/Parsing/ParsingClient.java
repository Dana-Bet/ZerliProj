package Parsing;

import Entities.Message;
import Entities.User;
import controlers.LoginScreenController;
public class ParsingClient {

	public static void Message(Object msg) {
		// TODO Auto-generated method stub
		Message receivedMessage = (Message) msg;
		
		switch (receivedMessage.getMessageType()) {

		case userlogin: {
			String[] DivedMsg = ((String) receivedMessage.getMessageData()).split("@");
			if (!receivedMessage.getMessageData().equals("WrongInput")) {
				if (receivedMessage.getMessageData().equals("Already")) {
					LoginScreenController.statusUser = "The user is already logged in";
					LoginScreenController.user = null;
				} else {
					if (receivedMessage.getMessageData().equals("Freeze")) {
						LoginScreenController.statusUser = "Frozen Account";
						LoginScreenController.user = null;
					} else {
						LoginScreenController.user = new User(DivedMsg[0], DivedMsg[1], DivedMsg[2], DivedMsg[3],
								DivedMsg[4], DivedMsg[5], DivedMsg[6],DivedMsg[7],DivedMsg[8]);
						LoginScreenController.statusUser = "Active";
					}
				}
			} else {
				LoginScreenController.statusUser = "User name or password are inccorect";
				LoginScreenController.user = null;
			}
			//IdentifyW4cController.client = null;
			//break;
		}
		

		default:{
			break;
		}
  }
}
}
