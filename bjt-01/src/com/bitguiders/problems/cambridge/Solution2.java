package com.bitguiders.problems.cambridge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution2 {
	
	
	public boolean isValid(String s){
		Pattern p = Pattern.compile("^.*(?=.*[a-z])(?=.*[A-Z])(?=..*[0-9]).*$");
		Matcher m = p.matcher(s);
		return m.find();
	}
	//one uppercase char
	//no digit
	//a0Ba

	public int solution(String s){
		int result = -1;
        for (String string : s.split(" ")) {
            if(string.matches(".*[^a-zA-Z0-9].*")) 
            	continue;
            else if(string.replaceAll("[0-9]", "").length() % 2 == 0 && 
               string.replaceAll("[a-zA-Z]", "").length() % 2 == 1)
                result = Math.max(result, string.length());
        }
        return result;
	}
	public int solution_(String s){
		//^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$
		//validate
		if(s==null || s.trim().length()==0){return -1;}
		int response=-1;
		if(isValid(s)){
			Pattern p = Pattern.compile("[0-9]");
			Matcher m = p.matcher(s);
			if(m.find()){
			System.out.println("Yes = "+m.start()+":"+m.end()+" "+s.substring(m.start(),m.end())+" = "+s.substring(m.end()).length());
			response = s.substring(m.end()).length();
			}
			
		}
		return response;
	}
	public static void main(String[] arg){
		Solution2 s = new Solution2();
		System.out.println(s.solution("a0bb"));
	}
}
