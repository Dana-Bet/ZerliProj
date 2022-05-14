package Querys;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entities.Order;



public class ShowOrders {

	public static ArrayList<Order> getOrders() {
		ArrayList<Order> orders = new ArrayList<>();
		Statement stmt;
		try {
			if (DBConnect.conn != null) {
				stmt = DBConnect.conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM order.orders");
				while (rs.next()) {
					int orderNumber = Integer.parseInt(rs.getString("OrderNumber"));
					int price = Integer.parseInt(rs.getString("price"));
					String greetingCard = rs.getString("greetingCard");
					String color = rs.getString("color");
					String dOrder = rs.getString("dOrder");
					String shop = rs.getString("shop");
					String date = rs.getString("date");
					String orderDate = rs.getString("orderDate");
					orders.add(new Order(orderNumber,price,greetingCard,color,dOrder,shop,date,orderDate));
				}
				rs.close();
			} else {
				System.out.println("Conn is null");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
}
