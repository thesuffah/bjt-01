package com.bitguiders.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _StringProgrammer {
public static int programmerStrings(String s){
		char t[] = "programmer".toCharArray();

		int count=0;
		int possibleMatches = s.length()/t.length;
		System.out.println(possibleMatches);
		try{
		int s0=0;
		int si=t.length+1;
		for(int i=0;i<possibleMatches;i++){
			String ss = s.substring(s0,si-1);
			System.out.println(s0+","+(si-1)+"="+ss);
				//verify if programmer exists
			  for(char c:t){
				  if(!ss.contains(c+"")){
					  return 0;
				  }
			  }
			count++;
			s0 +=t.length;
			si +=t.length+1;
		}
		}catch(StringIndexOutOfBoundsException e){
			return 0;
		}
		
		/*Matcher m = Pattern.compile("programmer").matcher(s);
		int foundCount=0;
		while(m.find()){
			System.out.println(m.start()+","+m.end());
			foundCount++;
		}
		return foundCount;*/
		return count;
	}
	public static boolean containsWord(String word,String data){
		boolean found=true;
		if(data.contains(word)){
			return found;
		}
		char wordChars[] = word.toCharArray();
		for(char c:wordChars){
			if(!data.contains(c+"")){
				return false;
			}
		}
		
		return found;
	}
	public static void main(String[] args) {
		
		String[] str ={"abdul","a-bdul","l-bd-ua","badl"};//{"programmerprogrammer","xprogxrmaxemrppprmmograeiruu","progxrammerrxproxgrammer"};
		for(String s:str){
		System.out.println(s+" = "+containsWord("abdul",s));
		}
	}

}
