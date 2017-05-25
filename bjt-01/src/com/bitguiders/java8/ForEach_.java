package com.bitguiders.java8;

import java.util.Hashtable;

public class ForEach_ {
	
	//neither null key, nor null values allowed, also its synchronized
	public static void hashtable(){
		System.out.println("\nHashtable = key,value ");
		Hashtable<String,String> table = new Hashtable<String,String>();
		table.put("a","a1");
		table.put("b","b2");
		table.put("c","c3");
		
		before:
		for(String key:table.keySet()){
			System.out.println("Before = "+key+","+table.get(key));
		}
		System.out.println();
		after:
		table.forEach((k,v)->System.out.println("After = "+k+","+v));
		
	}
	
	public static void main(String arg[]){
		hashtable();
	}
}
