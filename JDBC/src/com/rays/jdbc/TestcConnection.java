package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestcConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// step 1 load dri
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// step 2 make  connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun","root","root");
		//step 3 create statement
		Statement stmt = conn.createStatement();
		//step4 execute query nd get result
		ResultSet rs = stmt.executeQuery("select * from marksheet where rollNo = 1");
		System.out.println("---------connection succesfully-----");
		while(rs.next()) {
			
			System.out.println(rs.getInt(1));
			System.out.println("\t" + rs.getString(2));
			System.out.println("\t"+ rs.getInt(3));
			System.out.println("\t"+ rs.getInt(4));
			System.out.println("\t"+ rs.getInt(5));
		}
		
	}

}
