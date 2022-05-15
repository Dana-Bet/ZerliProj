package Parsing;

import java.util.ArrayList;

import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.MessageType;
import Querys.Query;
import controllers.LogicController;
import ocsf.server.ConnectionToClient;

public class ParsingServer {

	public static Message parsing(Object msg, ConnectionToClient client) {
		Message receivedMessage = (Message) msg;

		switch (receivedMessage.getMessageType()) {
		
		case userlogin: {
			String result;
			String[] DivededUandP = ((String) receivedMessage.getMessageData()).split("@");
			result = Query.Login(DivededUandP[0], DivededUandP[1]);
			if (!result.equals("Already") && !result.equals("WrongInput") && !result.equals("Freeze")) {
				LogicController.UpdateClientTable(msg, client);
			}
			return (new Message(MessageType.userlogin, result));
		}
		case Disconected: {
			Query.UpdateisLoggedIn((String) receivedMessage.getMessageData()); //sign user "isLoggedin" to 0
			LogicController.UpdateClientTable(msg, client);
			return ( new Message(MessageType.Disconected, null));
		} 
		case Initialize_Catalog:{
			String assembledProducts = (String) receivedMessage.getMessageData();
			ArrayList<Item_In_Catalog> Catalog= Query.Initialize_products(assembledProducts);
			return ( new Message(MessageType.Initialize_Catalog_succ, Catalog));
		}
		default:
			break;
		
		}
		return receivedMessage;
}

}
