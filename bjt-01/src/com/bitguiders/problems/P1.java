package com.bitguiders.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class P1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String thisLine = null;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    TreeSet<Integer> numbers = new TreeSet<Integer>();
	    
	        while ((thisLine = br.readLine()) != null) {
	           // System.out.println("---"+thisLine);
	        if((thisLine.toString()).contains(",")){ 
	            String[] csvNumbers = (thisLine.toString()).split(",");
	         for(String n:csvNumbers){
	             numbers.add(Integer.parseInt(n));
	         }//for end
	        }//if end
	        numbers.forEach(n->System.out.println(n));
	        }//while end
	         numbers.forEach(n->System.out.println(n));
	}

}
