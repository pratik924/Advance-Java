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
		
	}

}
