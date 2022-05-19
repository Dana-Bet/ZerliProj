package Entities;

public enum MessageType {

	/*Server Message*/
	Update_succesfuly,Show_Orders_succ,login,Disconected,Update_Not_succesfuly,Initialize_Catalog_succ,
	
	/*Client Message*/
	Update_Orders,Show_Orders,Show_Catalog,userlogin,add_account,ShowRevenueReport,ConfirmOpenNewAccount,Initialize_Catalog,
	getYear,getRevenueReports,RevenueReports_succ,getMonth, getTypeProduct,
	
	
	Error, getTypeProduct_succ, getTypeOrders, getTypeProductOrders_succ, getCustomerToFreeze, getCustomerToFreeze_succ, customerFreeze, getHomeStore, getHomwStore_succ,
	getTypeNames, getNamesitems_succ, UpdatePriceToItem,getTypeProductForUpdateCatalog,getTypeProductForCatalog_succ, getTypeProductForUpdateCatalog1,
}