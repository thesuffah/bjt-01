package com.bitguiders.problems.cracking_the_coding_interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.lang3.time.StopWatch;

public class Strings {

	/*
	 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
	 */
	public boolean isUnique(String input) {
		if(null==input) {
			
		}else if(input.trim().length()==1) {
		return true;
		}else if(input.trim().length()>1) {
			HashSet<Object> chars = new HashSet<>();
			for(char c:input.toCharArray()) {
				if(chars.contains(c)) {
					System.out.println("repeated char '"+c+"' found in "+input);
					return false;
				}else {
				chars.add(c);
				}
			}
		}
		return true;
	}
	public String URLify(String input,String oldChar,String newChar) {
		if(null!=input&&input.contains(oldChar)) {
			input = input.trim();
			input = input.replace(oldChar, newChar);
		}
		return input;
	}
	
	private String sort(String input) {
		if(null==input) 
			return "";
		
		char chars[]  = input.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	//Permutation is re arrangement of letters
	public boolean permutation(String firstWord,String secondWord) {
		if(firstWord==secondWord || firstWord.equals(secondWord)) {
			return true;
		}else {
			return sort(firstWord).equals(sort(secondWord));
		}
	}
	
	public String compress(String input) {
		if(null==input || input.length()<3) {
			return input;
		}
		char previousChar=input.charAt(0);
		int  previousCharCount=0;
		StringBuilder output = new StringBuilder();
		int index=0;
		
		for(char c:input.toCharArray()) {
			if(c==previousChar) {
				previousCharCount++;
			}else {
				output.append(previousChar).append(previousCharCount);
				previousChar=c;
				previousCharCount=1;
			}
						
			previousChar=c;
			index++;
			//last chunk
			if(index==input.length()) {
				output.append(previousChar).append(previousCharCount);
			}
		}
		return output.toString();
	}
	
	public boolean isSubstring(String str1,String str2) {
		str1 = sort(str1);
		str2 = sort(str2);
		
		return (str1.contains(str2)||str2.contains(str1)?true:false);
	}
	public static void main(java.lang.String[] args) {
		Strings strings = new Strings();
		
		//isUnique
		String[] words = {"abdul","kareem","amin"};
		System.out.println("\n--isUnique--");
		for(String word:words) {
		System.out.println(word+":"+strings.isUnique(word));
		}

		//permutation
		System.out.println("\n--permutation--");
		System.out.println("abdul,ulabd:"+strings.permutation("abdul", "ulabd"));
		System.out.println("kareem,akerm:"+strings.permutation("kareem", "akerm"));
		
		//URLify
		System.out.println("\n--URLify--");
		System.out.println(strings.URLify("Mr John Smith ", " ", "%20"));
		
		//compress
		System.out.println("\n--compress--");
		System.out.println("aabcccccaaa:"+strings.compress("aabcccccaaa"));
		System.out.println("aaa:"+strings.compress("aaa"));
		System.out.println("aa:"+strings.compress("aa"));
		System.out.println("a:"+strings.compress("a"));
		
		//permutation
		System.out.println("\n--isSubstring--");
		System.out.println("abdul,ulabd:"+strings.isSubstring("abdul", "ulabd"));
		System.out.println("kareem,akerm:"+strings.isSubstring("kareem", "akerm"));
		
	}

}
