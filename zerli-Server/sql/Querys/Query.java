package Querys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import Entities.Client;

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
					System.out.println(result);
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
					"INSERT INTO order.users (userName,password,Role,FirstName,LastName,ID,Email,phone,isLoggedIn) VALUES(?,?,?,?,?,?,?,?,?)");
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
					stmt3.setString(1, Account.getId());
					Random rand = new Random(); // instance of random class
					int int_random = rand.nextInt(1000);
					stmt3.setString(2, "Active");
					stmt3.setString(3, Account.getCreditCardNumber());
					stmt3.executeUpdate();
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
	}
}
