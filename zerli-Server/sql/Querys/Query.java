package Querys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
}
