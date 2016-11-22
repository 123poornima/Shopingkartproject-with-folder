package com.niit.shopingkartfront.util;

public class Util {
	public String replace(String st, String ch1, String ch2)
	{
		
	  return	st.replace(ch1, ch2);
		
	}
	
	
	public static void main(String[] args) {
		Util u = new Util();
		
		String newString =   u.replace(",PRD", ",", "");
		System.out.println(newString);
	}
}
