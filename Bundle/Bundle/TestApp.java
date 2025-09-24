package com.rays.Bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestApp {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.Bundle.app");
		System.out.println(rb.getString("url"));
		System.out.println("driver");
		
		ResourceBundle rb1 = ResourceBundle.getBundle("com.rays.Bundle.app", new Locale("hi"));
		System.out.println(rb1.getString("greeting"));
		ResourceBundle rb2 = ResourceBundle.getBundle("com.rays.Bundle.app", new Locale("up"));
		System.out.println(rb2.getString("greeting"));
		ResourceBundle rb3 = ResourceBundle.getBundle("com.rays.Bundle.app", new Locale("sp"));
		System.out.println(rb3.getString("greeting"));
		ResourceBundle rb4 = ResourceBundle.getBundle("com.rays.Bundle.app", new Locale("fr"));
		System.out.println(rb4.getString("greeting"));
		
	}

}
