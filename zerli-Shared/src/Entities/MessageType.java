package Entities;

public enum MessageType {

	/*Server Message*/
	Update_succesfuly,Show_Orders_succ,login,Disconected,Update_Not_succesfuly,Initialize_Catalog_succ,InitialShopsList_succ, getNamesitems_succ,getTypeProductForCatalog_succ,
	getHomwStore_succ,getTypeProductOrders_succ, getTypeProduct_succ,RevenueReports_succ,getCustomerToFreeze_succ,CreditCardList_succ,
	/*Client Message*/
	Update_Orders,Show_Orders,Show_Catalog,userlogin,add_account,ShowRevenueReport,ConfirmOpenNewAccount,Initialize_Catalog,
	getYear,getRevenueReports,getMonth, getTypeProduct, getTypeOrders, getCustomerToFreeze,customerFreeze, getHomeStore, 
	getTypeNames,  UpdatePriceToItem,getTypeProductForUpdateCatalog, getTypeProductForUpdateCatalog1, InitialShopsList,CreditCardList,
	
	
	Error, 
}