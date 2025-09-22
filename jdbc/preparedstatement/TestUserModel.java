package com.rays.jdbc.preparedstatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception, SQLException {

		//testadd();
		testDelete();
		//testUpdate();
		//testFindByLogin();
		//testAuthenticate();
		//testChangePassword();
		//testSearch();
	}

	private static void testadd() throws ParseException, ClassNotFoundException, SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model = new UserModel();
		
		UserBean bean = new UserBean();

		bean.setFirstName("pratik");
		bean.setLastName("parihar");
		bean.setLogin("parihar@gmail.com");
		bean.setPassword("singh.com");
		bean.setDob(sdf.parse("2002-09-30"));

		model.add(bean);

	}
	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(9);
		model.Delete(bean);
	}
    public static void  testUpdate() throws Exception  {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	
    	UserModel model = new UserModel();
    	UserBean bean =  new UserBean();
    	
    	bean.setId(4);
    	bean.setFirstName("lucky");
    	bean.setLastName("maurya");
    	bean.setLogin("lucky@gmail.com");
    	bean.setPassword("lucky@123");
    	bean.setDob(sdf.parse("2004-08-03"));
    	model.Update(bean);
    }
    public static void testFindByLogin() throws Exception {
    	UserModel model = new UserModel();

		UserBean existsBean = model.findByLogin("parihar@gmail.com");

		if (existsBean != null) {
			System.out.println("login id is already exist");
		} else {
			System.out.println("no record found");
		}
    }
    public static void testAuthenticate() throws Exception {
    	
    	UserModel model = new UserModel();
    	UserBean existBean = model.authenticates("parihar@gmail.com", "singh.com");
    	if(existBean != null) {
    		System.out.println("login succesfully");
    	}else {
    		System.out.println("no data matched");
    		
    	}
    }
    public static void testChangePassword() throws Exception {
    	UserModel model = new UserModel();
    	model.changePassword("singh123","singh321" , "parihar@gmail.com");
    }
    public static void testSearch() throws Exception {
    	UserModel model = new UserModel();
    	List list = model.search(null);
    	Iterator<UserBean> it = list.iterator();
    	while(it.hasNext()) {
    		
    		UserBean bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getLogin());
			System.out.print("\t"+bean.getPassword());
			System.out.println("\t"+bean.getDob());
    		
    	}
    	
    }
}
