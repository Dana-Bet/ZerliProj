package Parsing;

import java.util.ArrayList;

import Entities.ClientCart;
import Entities.Complaint;
import Entities.CreditCard;
import Entities.Item_In_Catalog;
import Entities.Message;
import Entities.OrdersReport;
import Entities.RevenueReport;
import Entities.Store;
import Entities.User;
import controlers.CEOViewReportsOrdersController;
import controlers.CartScreenController;
import controlers.ClientAssemblyProductController;
import controlers.ClientCatalogController;
import controlers.ClientOrderPageController;
import controlers.LoginScreenController;
import controlers.ManagerAddAccountController;
import controlers.ManagerFreezeController;
import controlers.ManagerViewReportsOrders;
import controlers.ManagerViewReportsRevenueController;
import controlers.UpdateItemsInCatalogController;
import controlers.PaymentScreenController;
import controlers.TableComplaintsScreenController;

public class ParsingClient {

	@SuppressWarnings({ "unchecked", "deprecation" })
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
						CartScreenController.cart = new ClientCart();
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
		case Initialize_Catalog_succ :{
			ArrayList<Item_In_Catalog> Catalog= new ArrayList<>();
			Catalog = (ArrayList<Item_In_Catalog>) (receivedMessage.getMessageData());
			if(Catalog.get(0).isAssembleItem().compareTo("0")==0) {
				ClientCatalogController.Catalog=Catalog;
				ClientCatalogController.catalog_Initilaize = true;
			}
			else {
				ClientAssemblyProductController.Catalog=Catalog;
				ClientAssemblyProductController.catalog_Initilaize = true;
			}
		}
		case getYear: {
			ManagerViewReportsRevenueController.years = (ArrayList<String>) receivedMessage.getMessageData();
			break;
		}
		case getMonth: {
			ManagerViewReportsRevenueController.months = (ArrayList<String>) receivedMessage.getMessageData();
			break;
		}
		case RevenueReports_succ: {
			ManagerViewReportsRevenueController.ViewReportsRevenueFlag = true;
			ManagerViewReportsRevenueController.revenue = (ArrayList<RevenueReport>)(receivedMessage.getMessageData());
			break;
		}
		case getTypeProduct_succ: {
			ManagerViewReportsOrders.productType = (ArrayList<String>)(receivedMessage.getMessageData());
			break;
		}
		case getTypeProductOrders_succ: {
			ManagerViewReportsOrders.productTypeOrders = (ArrayList<OrdersReport>)(receivedMessage.getMessageData());
			break;
		}
		case getCustomerToFreeze_succ:{
			ManagerFreezeController.customerList =  (ArrayList<String>)(receivedMessage.getMessageData());
		}
		case getHomwStore_succ:{
			ManagerFreezeController.homeStoreList = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		case getNamesitems_succ:{
			UpdateItemsInCatalogController.NamesproductList = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		case getTypeProductForCatalog_succ:{
			UpdateItemsInCatalogController.productType1 = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		case InitialShopsList_succ :{
			ArrayList<Store> stores= new ArrayList<>();
			stores = (ArrayList<Store>) (receivedMessage.getMessageData());
			ClientOrderPageController.storesList = stores;
		}
		case CreditCardList_succ :{
			PaymentScreenController.cardList =  (ArrayList<CreditCard>) (receivedMessage.getMessageData());
		
		}
		case CreditValue_succ :{
			PaymentScreenController.CreditAmmount =receivedMessage.getMessageData() ;
		
		}
		case CreditUsed_succ:{
			
		}
		
		case Add_New_Payment_Method_succ:{
			
		}
		case Add_Order_succ:{
		
		}
		case IsNewClient_succ:{
			PaymentScreenController.newClient= receivedMessage.getMessageData();		
		}
		case UpdateNewClientDiscount_succ:{
			
		}
		case getIdFromComplaitnDB_succ:{
			TableComplaintsScreenController.listID = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		case getTableComplaintsFromDB_succ:{
			TableComplaintsScreenController.listTable = (ArrayList<Complaint>)(receivedMessage.getMessageData());
		}
		case getHomwStoreForCEOordersReports_succ:{
			CEOViewReportsOrdersController.stores = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		case getTypeProductForCEOordersReports_succ:{
			CEOViewReportsOrdersController.types = (ArrayList<String>)(receivedMessage.getMessageData());
		}
		case getCEOordersReports_succ:{
			CEOViewReportsOrdersController.reports = (ArrayList<OrdersReport>)(receivedMessage.getMessageData());
		}
		default:{
			break;
		}
  }
}
	
	
}