package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun","root","root");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("insert into marksheet values(21,'kunal',56,65,78),(22,'raman',78,63,69)");
		System.out.println("data inserted succesfully:"+i);
		
	}

}
