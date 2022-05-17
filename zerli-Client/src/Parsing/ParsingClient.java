package Parsing;

import java.util.ArrayList;

import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.RevenueReport;
import Entities.User;
import controlers.ClientCatalogController;
import controlers.LoginScreenController;
import controlers.ManagerAddAccountController;
import controlers.ManagerViewReportsRevenueController;

public class ParsingClient {

	@SuppressWarnings("unchecked")
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
		}
		
		case ConfirmOpenNewAccount: {
			ManagerAddAccountController.ConfirmOpenNewAccountFlag = true;
			break;
		}
		case ShowRevenueReport:{
			ManagerViewReportsRevenueController.ViewReportsRevenueFlag = true;
		}
		case Initialize_Catalog_succ :{
			
		}
		case getYear: {
			ManagerViewReportsRevenueController.years = (ArrayList<String>) receivedMessage.getMessageData();
			break;
		}
		case RevenueReports_succ: {
			ManagerViewReportsRevenueController.ViewReportsRevenueFlag = true;
			ManagerViewReportsRevenueController.revenue = (ArrayList<RevenueReport>)(receivedMessage.getMessageData());	
		}
		
		default:{
			break;
		}
  }
}
}