package com.bitguiders.java8;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.List;

public class StringJoiner_ {

	public static void join(){
		String str = String.join("-", "872","000","00");
		System.out.println(str);
		
		StringJoiner sj = new StringJoiner("-");
		sj.add("872");
		sj.add("000");
		sj.add("00");
		System.out.println(sj);
		
		List<String> list = Arrays.asList("872","000","00");
		str = String.join("-", list);
		System.out.println(str);
		
		str = list.stream().map(x -> x).collect(Collectors.joining("-"));
		System.out.println(str);
		
		str = list.stream().map(x -> x).collect(Collectors.joining("-","{","}"));
		System.out.println(str);

	}
	public static void main(String[] args) {
		join();
	}

}
