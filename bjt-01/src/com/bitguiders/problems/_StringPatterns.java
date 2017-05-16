package com.bitguiders.problems;

import java.util.regex.Pattern;

public class _StringPatterns {


	public static boolean isValid(String s){
		
		s = Pattern.compile("\\(\\)").matcher(s).replaceAll("");
		s = Pattern.compile("\\{\\}").matcher(s).replaceAll("");
		s = Pattern.compile("\\[\\]").matcher(s).replaceAll("");
		
		return (s.length()==0?true:false);
	}
	public static void main(String[] args) {
		String[] str ={"[{()}]","{[)}","{}[]()","123KL"};
		for(String s:str){
		System.out.println(s+" = "+isValid(s));
		}
		
	}

}
