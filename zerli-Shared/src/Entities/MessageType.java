package Entities;

public enum MessageType {

	/*Server Message*/
	Update_succesfuly,Show_Orders_succ,login,Disconected,Update_Not_succesfuly,Initialize_Catalog_succ,InitialShopsList_succ, getNamesitems_succ,getTypeProductForCatalog_succ,
	getHomwStore_succ,getTypeProductOrders_succ, getTypeProduct_succ,RevenueReports_succ,getCustomerToFreeze_succ,CreditCardList_succ, CreditValue_succ,CreditUsed_succ,
	Add_New_Payment_Method_succ, Add_Order_succ,IsNewClient_succ,UpdateNewClientDiscount_succ,Get_All_Order_by_id_succ,  
	/*Client Message*/
	Update_Orders,Show_Orders,Show_Catalog,userlogin,add_account,ShowRevenueReport,ConfirmOpenNewAccount,Initialize_Catalog,
	getYear,getRevenueReports,getMonth, getTypeProduct, getTypeOrders, getCustomerToFreeze,customerFreeze, getHomeStore, 
	getTypeNames,  UpdatePriceToItem,getTypeProductForUpdateCatalog, getTypeProductForUpdateCatalog1, InitialShopsList,CreditCardList,
	CreditValue, CreditUsed, Add_New_Payment_Method,Add_Order,IsNewClient,UpdateNewClientDiscount,Get_All_Order_by_id, 
	
	Error,
}