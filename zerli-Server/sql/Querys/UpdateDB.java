package Querys;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import Entities.Order;

public class UpdateDB {

	public static boolean IfOrderExist(String OrderNumber) {
		
		boolean flag = false;
		 try {
			if (DBConnect.conn != null) {
		
				Statement st = DBConnect.conn.createStatement();
				String sql = "SELECT * FROM order.orders";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					String o_number_col = rs.getString("OrderNumber");
					if(o_number_col.compareTo(OrderNumber) == 0) {
							flag = true;
							break;
					}
				}
	 		
		} else {
			System.out.println("Conn is null");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

		return flag;
}
	
	
	public static void UpdateColorAndDate(String OrderNumber,String color,String date){
		PreparedStatement stmt = null;
			try {
				if (DBConnect.conn != null) {

					int flag = 0;
					Statement st = DBConnect.conn.createStatement();
					String sql = "SELECT * FROM order.orders";
					ResultSet rs = st.executeQuery(sql);
					while(rs.next()) {
						String o_number_col = rs.getString("OrderNumber");
						if(o_number_col.compareTo(OrderNumber) == 0) {
								flag = 1;
								break;
						}
					}
					if(flag == 0)
						System.out.println("Order is not exist");
					
				stmt = DBConnect.conn.prepareStatement("UPDATE order.orders SET color = ? where OrderNumber = ? ");
				stmt.setString(1,color);
				stmt.setString(2,OrderNumber);
		 		stmt.executeUpdate();
		 		stmt = DBConnect.conn.prepareStatement("UPDATE order.orders SET date = ? where OrderNumber = ?");
				stmt.setString(1,date);
				stmt.setString(2,OrderNumber);
		 		stmt.executeUpdate();
		 		
			} else {
				System.out.println("Conn is null");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}











//st = DBConnect.conn.createStatement();
//String sql =String.format( "SELECT EXISTS(SELECT FROM order.orders WHERE OrderNumber = %d )",OrderNumber);
//ResultSet res = st.executeQuery(sql);
//System.out.println(res);
//	if(!res.next()) {
 //     System.out.println("The order is not exist");
 ///     return;
//	}
//stmt = DBConnect.conn.prepareStatement("SELECT EXISTS(SELECT FROM order.orders SET OrderNumber = ? ");
//stmt.setString(1,OrderNumber);
