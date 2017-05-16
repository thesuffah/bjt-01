package com.bitguiders.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bitguiders.util.User;

public class Lambda_ {
	public enum SORT{ASC,DESC};
	public void sort(List<User> users,Lambda_.SORT sort){
		
		switch(sort){
		case ASC:
		Collections.sort(users,(u1,u2)-> u1.getUserName().compareTo(u2.getUserName()) );
		break;
		case DESC:
		Collections.sort(users,(u1,u2)-> -1*u1.getUserName().compareTo(u2.getUserName()) );
		break;
		}
		System.out.println();
		users.forEach(u-> System.out.println(u.toString()));
	}
	public static void main(String arg[]){
		List<User> users = new ArrayList<User>();
		users.add(new User("Waqas","admin"));
		users.add(new User("Abdul Kareem","user"));
		users.add(new User("Sohail","user"));

		Lambda_ lambda = new Lambda_();
		lambda.sort(users,Lambda_.SORT.ASC);
		lambda.sort(users,Lambda_.SORT.DESC);
	}
}
