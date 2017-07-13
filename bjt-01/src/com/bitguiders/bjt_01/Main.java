package com.bitguiders.bjt_01;

import com.bitguiders.util.User;

public class Main extends Static {

	public static void main(String... arg){
		System.out.println("...");
		User user = new User("Abdul","Kareem");
		System.out.println(user.toString());
		System.out.println(128>>4);;
		
		int[] oldArray = { 3, 5, 7, 9};
int[] newArray = { 2, 4, 6, 8, 9, 7, 5, 3};
System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
System.out.println(Math.ceil(-82.4));
System.out.println(Math.pow(-6, 2));

 
	}
}
