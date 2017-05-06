package com.bitguiders.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bitguiders.util.User;

public class Lambda {

	public void sort(){
		List<User> users = new ArrayList<User>();
		users.add(new User("Waqas","admin"));
		users.add(new User("Abdul Kareem","user"));
		users.add(new User("Sohail","user"));
		
		Collections.sort(users,(u1,u2)-> u1.getUserName().compareTo(u2.getUserName()) );
		//Collections.sort(users,(u1,u2)-> -1*u1.getUserName().compareTo(u2.getUserName()) );
		users.forEach(u-> System.out.println(u.toString()));
	}
	public static void main(String arg[]){
		Lambda lambda = new Lambda();
		lambda.sort();
	}
}
