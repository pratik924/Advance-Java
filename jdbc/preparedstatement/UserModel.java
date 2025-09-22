package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
	public int nextPK() throws ClassNotFoundException, SQLException {
		int PK = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select max(id)from st_user");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			PK = rs.getInt(1);

		}

		return PK + 1;

	}

	public void add(UserBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into  st_user values(?,?,?,?,?,?)");
		int PK = nextPK();
		pstmt.setInt(1, PK);
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLogin());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

		int i = pstmt.executeUpdate();
		System.out.println("data inserted succesfuly:" + i);
		conn.close();
	}

	public void Delete(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");

		pstmt.setInt(1, bean.getId());
		int i = pstmt.executeUpdate();
		System.out.println("data deleted succesfully:" + i);
		conn.close();
	}

	public void Update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set firstName = ?, lastName = ?,login = ?,password = ?,dob = ? where id = ?");
		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLogin());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(6, bean.getId());
		int i = pstmt.executeUpdate();
		System.out.println("data updated succesfully:" + i);
		conn.close();

	}

	public UserBean findByLogin(String login) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ?");
		pstmt.setString(1, login);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

		}

		conn.close();
		return bean;
	}

	public UserBean authenticates(String login, String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where  login = ? and password = ?");
		pstmt.setString(1, login);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

		}
		conn.close();
		return bean;

	}

	public void changePassword(String oldPassword, String newPassword, String login) throws Exception {
		UserBean existBean = findByLogin(login);

		System.out.println("database password: " + existBean.getPassword());
		System.out.println("oldPassword: " + oldPassword);

		if (existBean.getPassword().equals(oldPassword)) {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun", "root", "root");
			PreparedStatement pstmt = conn.prepareStatement("update st_user set password = ? where login = ?");

			pstmt.setString(1, newPassword);
			pstmt.setString(2, login);

			int i = pstmt.executeUpdate();
			System.out.println("password has been changed: " + i);
			conn.close();

		} else {
			throw new Exception("old password is incorrect");
		}
	}

	public List search(UserBean bean) throws Exception {

		List list = new ArrayList();

		StringBuffer sql = new StringBuffer("select * from st_user");

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun", "root", "root");

		System.out.println("sql ----> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			list.add(bean);

		}

		return list;

	}

}
