package Querys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entities.Client;
import Entities.Item_In_Catalog;
import Entities.Order;
import Entities.RevenueReport;

public class Query {

	public static String Login(String userName, String password) {
		StringBuilder result = new StringBuilder();
		String role = null, ID = null, status = null;
		PreparedStatement stmt, stmt1;
		try {
			if (DBConnect.conn != null) {
				stmt = DBConnect.conn.prepareStatement(
						"SELECT Role,ID,FirstName,LastName,userName,password,isLoggedIn,phone,email FROM zerli_db.users WHERE userName=? AND password=?");
				stmt.setString(1, userName);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					if ((rs.getString(7)).equals("1")) {
						return "Already";
					}
					role = rs.getNString(1);
					result.append(rs.getString(1));
					result.append("@");
					ID = rs.getString(2);
					result.append(rs.getString(2));
					result.append("@");
					result.append(rs.getString(3));
					result.append("@");
					result.append(rs.getString(4));
					result.append("@");
					result.append(rs.getString(5));
					result.append("@");
					result.append(rs.getString(6));
					result.append("@");
					result.append(rs.getString(7));
					result.append("@");
					result.append(rs.getString(8));
					result.append("@");
					result.append(rs.getString(9));
				}
				rs.close();
				if (result.length() == 0) {
					return "WrongInput";
				}
				if (role.equals("Customer")) {
					stmt1 = DBConnect.conn.prepareStatement("SELECT status FROM zerli_db.client WHERE client_id=?");
					stmt1.setString(1, ID);
					ResultSet rs1 = stmt1.executeQuery();
					while (rs1.next()) {
						status = rs1.getString(1);
					}
					rs1.close();
					if (status.equals("Freeze")) {
						return "Freeze";
					}
				}
				stmt = DBConnect.conn.prepareStatement("UPDATE zerli_db.users SET isLoggedIn='1' WHERE userName=? AND password=?");
				stmt.setString(1, userName);
				stmt.setString(2, password);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static void UpdateisLoggedIn(String UserName) {
		PreparedStatement stmt;
		try {
	    	stmt = DBConnect.conn.prepareStatement("UPDATE zerli_db.users SET isLoggedIn='0' WHERE userName=?");
	    	stmt.setString(1, UserName);
		    stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//the method check if account exist
	public static boolean IfAccountExist(Client Account) {
		System.out.println("line 75 - query");
		boolean flag = false;
		 try {
			if (DBConnect.conn != null) {
		
				Statement st = DBConnect.conn.createStatement();
				String sql = "SELECT * FROM zerli_db.account";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					String id_col = rs.getString("ID");
					if(id_col.compareTo(Account.getId()) == 0) {
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
	public static void addNewAccount(Client Account) {
		if (DBConnect.conn != null) {
			try {
					PreparedStatement stmt2 = DBConnect.conn.prepareStatement(
					"INSERT INTO zerli_db.users (userName,password,Role,FirstName,LastName,ID,email,phone,isLoggedIn) VALUES(?,?,?,?,?,?,?,?,?)");
					stmt2.setString(1, Account.getUserName());
					stmt2.setString(2, Account.getPassword());
					stmt2.setString(3, Account.getRole());
					stmt2.setString(4, Account.getFirstN());
					stmt2.setString(5, Account.getLastN());
					stmt2.setString(6, Account.getId());
					stmt2.setString(7, Account.getEmail());
					stmt2.setString(8, Account.getPhone());
					stmt2.setInt(9, 0); //The account insert in looggedId = 0
					stmt2.executeUpdate();
					PreparedStatement stmt3 = DBConnect.conn.prepareStatement(
							"INSERT INTO client (client_id,status,CreditCardNumber) VALUES(?,?,?)");
					System.out.println("line 133");
					stmt3.setString(1, Account.getId());
					System.out.println("line 135");
					stmt3.setString(2, "Active");
					System.out.println("line 137");
					stmt3.setString(3, Account.getCreditCardNumber());
					System.out.println("line 139");
					stmt3.executeUpdate();
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
	}
	
	public static ArrayList<Item_In_Catalog> Initialize_products(String assembledItem) {
		ArrayList<Item_In_Catalog> Catalog= new ArrayList<>();
		PreparedStatement stmt;
		try {
			if (DBConnect.conn != null) {
				stmt = DBConnect.conn
						.prepareStatement("SELECT * FROM zerli_db.item_in_catalog WHERE assembleItem =?");
				stmt.setString(1, assembledItem);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Item_In_Catalog Item = new Item_In_Catalog(rs.getInt("id"), rs.getString("color"),
							rs.getString("name"), rs.getString("type"), rs.getFloat("price"),
							rs.getString("assembleItem"));
					Catalog.add(Item);
				}
				rs.close();
			} else {
				System.out.println("Conn is null");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Catalog;
		}
	
	//this method take the years in revenue_reports for DB
		public static ArrayList<String> getYear() {
			ArrayList<String> years = null;
			Statement stmt;
			try {
				stmt = DBConnect.conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT DISTINCT year FROM zerli_db.revenue_reports");
				years = new ArrayList<String>();
				while (rs.next()) {
				years.add(rs.getString(1));
				}
					rs.close();
				} catch (SQLException e) {
			e.printStackTrace();
				}
			return years;
		}
		
		public static ArrayList<RevenueReport> getRevenueReports(RevenueReport report) {
			ArrayList<RevenueReport> revenue = new ArrayList<>();
			PreparedStatement stmt;
			try {
				if (DBConnect.conn != null) {
					stmt = DBConnect.conn.prepareStatement("SELECT * FROM zeli_db.revenue_reports WHERE store =? AND month=? AND year=?");
					stmt.setString(1, report.getStoreName());
					stmt.setString(2, report.getMonth());
					stmt.setString(3,report.getYear());
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						RevenueReport report1 = new RevenueReport(rs.getString("store"),rs.getString("month"),rs.getString("year"),
								rs.getString("orders_amount"),rs.getShort("income"),rs.getString("Quarterly"));
						revenue.add(report1);
					}
					rs.close();
				} else {
					System.out.println("Conn is null");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return revenue;
		}
	}






