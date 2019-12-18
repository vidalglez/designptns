package com.example.db.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyDemo {

	public static void main(String[] args) {
		String url = "jdbc:derby:/Users/vidal/Documentos/codebase/derbydb/demo;create=true";
		try (Connection conn = DriverManager.getConnection(url)) {
			Statement stmt = conn.createStatement();
			String sql = "CREATE TABLE Species ( "
					+ "id INTEGER PRIMARY KEY, "
					+ "name VARCHAR(255), "
					+ "num_acres DECIMAL "
					+ ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			sql = "INSERT INTO Species VALUES(1, 'Elephant', 7.5)";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			sql = "INSERT INTO Species VALUES(2, 'Zebra', 1.2)";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			System.out.println("Records added!");
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
