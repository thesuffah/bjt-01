package com.bitguiders.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.bitguiders.util.User;

import sun.security.pkcs11.wrapper.Functions;


public class Stream_ {
	List<User> list = Arrays.asList( new User("Waqas","user"),
			new User("Abdul Kareem","admin"),new User("Sohail","user"));

	public void filter(){
		System.out.println("\nJava 8 Filter example ");
		List<User> result= list.stream()
				.filter(u->! u.getUserName().equals("Sohail"))
				.collect(Collectors.toList());
		
		//result.forEach(System.out::println);
		System.out.println(result);
		
		//findany
		User user = list.stream().filter(u->u.getUserName().equals("Sohail"))
				.findAny()
				.orElse(null);
		System.out.println(user);
	}
	public void map(){
		System.out.println("\nJava 8 Map example ");
		List<String> result= list.stream()
				.filter(u->! u.getUserName().equals("Sohail"))
				.map(User::getUserName)
				.collect(Collectors.toList());
		
		//result.forEach(System.out::println);
		System.out.println(result);
		
		//findany
		String user = list.stream()
				.filter(u->u.getUserName().equals("Sohail"))
				.map(User::getUserName)
				.findAny()
				.orElse(null);
		System.out.println(user);
	}
	public void groupBy(){
		System.out.println("\nJava 8 groupBy example ");
		Map<String, Long> result= list.stream()
				.map(User::getPassword)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()) );
		
		System.out.println(result);
	}

	public static void main(String[] args) {
		Stream_ s = new Stream_();
		s.filter();
		s.map();
		s.groupBy();
	}

}
