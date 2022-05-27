package Parsing;

import java.util.ArrayList;

import Entities.Client;
import Entities.CreditCard;
import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.MessageType;
import Entities.OrdersReport;
import Entities.RevenueReport;
import Entities.Store;
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
		case add_account: {
			Client Nclient = (Client) receivedMessage.getMessageData();
				Query.addNewAccount(Nclient);
				return (new Message(MessageType.ConfirmOpenNewAccount, null));
			}
		case getYear:{
			ArrayList<String> years = (ArrayList<String>) Query.getYear();
			return (new Message(MessageType.getYear, years));
		}
		case getMonth:{
			ArrayList<String> months = (ArrayList<String>) Query.getMonth();
			return (new Message(MessageType.getMonth, months));
		}
		case getRevenueReports: {
			ArrayList<String> details = (ArrayList<String>)receivedMessage.getMessageData();
			ArrayList<RevenueReport> revenue = Query.getRevenueReports(details);
			return (new Message(MessageType.RevenueReports_succ,revenue));
		}
		case getTypeProduct: {
			ArrayList<String> productype = (ArrayList<String>) Query.getProductType();
			return (new Message(MessageType.getTypeProduct_succ,productype));
		}
		case getTypeOrders:{
			String type = (String) receivedMessage.getMessageData();
			ArrayList<OrdersReport> typeOrders = Query.getTypeOrders(type);
			return (new Message(MessageType.getTypeProductOrders_succ,typeOrders));
		}
		case getCustomerToFreeze:{
			String storeManager = (String)(receivedMessage.getMessageData());
			ArrayList<String> customerList = Query.getCustomerToFreeze(storeManager);
			return (new Message(MessageType.getCustomerToFreeze_succ, customerList));
		}
		
		case customerFreeze:{
			String customerToFreeze = (String)(receivedMessage.getMessageData());
			Query.FreezeCustomer(customerToFreeze);
		}
		case getHomeStore:{
			ArrayList<String> storelist = (ArrayList<String>) Query.getstorelist();
			return (new Message(MessageType.getHomwStore_succ,storelist));
		}
		case getTypeNames:{
			String type = (String) receivedMessage.getMessageData();
			ArrayList<String> Namelist = (ArrayList<String>) Query.getNamesList(type);
			return (new Message(MessageType.getNamesitems_succ,Namelist));
		}
		case UpdatePriceToItem:{
			ArrayList<String> details = (ArrayList<String>)(receivedMessage.getMessageData());
			ArrayList<String> updatePrice = Query.setDetailsInItem(details);
		}
		case getTypeProductForUpdateCatalog1: {
			ArrayList<String> productype = (ArrayList<String>) Query.getProductType1();
			return (new Message(MessageType.getTypeProductForCatalog_succ,productype));
		}
		case InitialShopsList:{
			ArrayList<Store> Stores= Query.InitialShopsList();
			return (new Message(MessageType.InitialShopsList_succ,Stores));
			
		}
		case CreditCardList:{
			String userId = (String) receivedMessage.getMessageData();
			ArrayList<CreditCard> creditCards= Query.CreditCardList(userId);
			return (new Message(MessageType.CreditCardList_succ,creditCards));
		}
		case CreditValue:{
			String userId = (String) receivedMessage.getMessageData();
			int credit= Query.getCreditValue(userId);
			return (new Message(MessageType.CreditValue_succ,credit));
		}
		case CreditUsed:{
			String[] DivededUandCredit = ((String) receivedMessage.getMessageData()).split("@");
			Query.setCreditValue(DivededUandCredit[0], DivededUandCredit[1]);
			return (new Message(MessageType.CreditUsed_succ,""));
		}
		case Add_New_Payment_Method : {
			String[] DivededUandCredit = ((String) receivedMessage.getMessageData()).split("@");
			System.out.println(DivededUandCredit[0]+ DivededUandCredit[1]);
			Query.AddCreditCard(DivededUandCredit[0], DivededUandCredit[1]);
			return (new Message(MessageType.Add_New_Payment_Method_succ,""));
		}
		case Add_Order:{
			String[] DivedOrderDet = ((String) receivedMessage.getMessageData()).split("@");
			Query.AddOrderToDb(DivedOrderDet[0],DivedOrderDet[1],DivedOrderDet[2],DivedOrderDet[3],DivedOrderDet[4],
					DivedOrderDet[5],DivedOrderDet[6],DivedOrderDet[7]);
			return (new Message(MessageType.Add_Order_succ,""));
		}
		case IsNewClient:{
			String userId = (String) receivedMessage.getMessageData();
			int res= Query.IsNewClient(userId);
			return (new Message(MessageType.IsNewClient_succ,res));
		}
		case  UpdateNewClientDiscount:{
			String userId = (String) receivedMessage.getMessageData();
			Query.UpdateNewClientDisc(userId);
			return (new Message(MessageType.UpdateNewClientDiscount_succ,""));
		}
		case Get_All_Order_by_id :{
			String userId = (String) receivedMessage.getMessageData();
			return (new Message(MessageType.Get_All_Order_by_id_succ,Query.get_Orders_list(userId)));
			
		}
		default:
			break;
		
		}
		return receivedMessage;
}

}
