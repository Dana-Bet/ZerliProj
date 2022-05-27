package Entities;

public enum MessageType {

	/*Server Message*/
	Update_succesfuly,Show_Orders_succ,login,Disconected,Update_Not_succesfuly,Initialize_Catalog_succ,
	
	/*Client Message*/
	Update_Orders,Show_Orders,Show_Catalog,userlogin,add_account,ShowRevenueReport,ConfirmOpenNewAccount,Initialize_Catalog,
	getYear,getRevenueReports,RevenueReports_succ,getMonth, getTypeProduct,
	
	
	Error, getTypeProduct_succ, getTypeOrders, getTypeProductOrders_succ, getCustomerToFreeze, getCustomerToFreeze_succ, customerFreeze, getHomeStore, getHomwStore_succ,
	getTypeNames, getNamesitems_succ, UpdatePriceToItem,getTypeProductForUpdateCatalog,getTypeProductForCatalog_succ, getTypeProductForUpdateCatalog1,
	getIdFromComplaitnDB, getIdFromComplaitnDB_succ, ShowTableComlaintInDB, getTableComplaintsFromDB_succ, setRefundToClient, GetStore,
	getStore_succ, getTypesForCEOordersReports, getTypeProductForCEOordersReports_succ, getStoresForCEOordersReports, getHomwStoreForCEOordersReports_succ, getCEOordersReport, getCEOordersReports_succ, InitialShopsList, CreditCardList, CreditValue, CreditUsed, Add_New_Payment_Method, Add_Order, IsNewClient, UpdateNewClientDiscount, UpdateNewClientDiscount_succ, IsNewClient_succ, Add_Order_succ, Add_New_Payment_Method_succ, CreditUsed_succ, CreditValue_succ, CreditCardList_succ, InitialShopsList_succ,
}