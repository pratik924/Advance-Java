package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestRemove {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun","root","root");
     Statement stmt = conn.createStatement();
	int i = stmt.executeUpdate("delete from marksheet where rollNo =22");
	System.out.println("deleted succesfully");
	
	}

}
