package com.bitguiders.bjt_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparables {

	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		users.add(new User("Waqas","admin"));
		users.add(new User("Abdul Kareem","user"));
		users.add(new User("Sohail","user"));
		
		System.out.println("Before sort :");
		users.forEach(u->System.out.println(u.toString()));
		
		Collections.sort(users);
		System.out.println("\nAfter Asc order sort :");
		users.forEach(u->System.out.println(u.toString()));

		Collections.sort(users,new CustomComparator());
		System.out.println("\nAfter Desc order sort :");
		users.forEach(u->System.out.println(u.toString()));
	}

}
class CustomComparator implements Comparator<User> {

	@Override
	public int compare(User u1, User u2) {
		return -1*u1.getUserName().compareTo(u2.getUserName());
	}
	
}

 class User implements Comparable<User> {

	private String userName;
	private String password;

	public User(){}
	public User(String userName,String password){
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessage(){
		return "Welcome "+userName;
	}
	@Override
	public int compareTo(User u) {
		return getUserName().compareTo(u.getUserName());
	}
	public String toString(){
		return userName+","+password;
	}
}