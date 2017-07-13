package com.bitguiders.problems.hacker_rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardValidation {

	public static boolean isValidCreditCard(String cc){
    	String regex = "[11, 3434, 67453, 9]";
    	Matcher m = Pattern.compile(regex).matcher(cc);
    	
    	return m.find(); 
    }
	public static boolean isValid(String cc){
		
		char[] numbers = cc.toCharArray();
		int checkDigit = Integer.parseInt(numbers[numbers.length-1]+"");
		for(int i=0;i<numbers.length-1;i++){
			//System.out.print(numbers[i]+" ");
		}
		//System.out.println();
		int sum =0;
		for(int i=0;i<numbers.length-1;i++){
			int n = Integer.parseInt(numbers[i]+"");
			sum +=(n*2);
			//System.out.print(n*2+" ");
		}

		//System.out.println("Sum = "+sum+" = "+checkDigit+" ans = "+(sum%10));
		return ((sum%10)==checkDigit?true:false);
	}
	public static boolean isAllowed(String[] bannedPrefixes,String cc){
		cc = cc.trim();
		for(String prefix: bannedPrefixes){
			String[] patterns = prefix.split(",");
			for(String pattern:patterns){
				if(cc.startsWith(pattern.substring(0,1))){
				System.out.println("f pattern= "+pattern+" , start char ="+pattern.charAt(0)+" cc = "+cc.charAt(0));
				return false;
				}
			}
		}
		return true;
	}
	
static List<Map<String, Object>> validateCards(String[] bannedPrefixes, String[] cardsToValidate) {
		
	   List<Map<String,Object>> validatedCards = new ArrayList<Map<String,Object>>();
	     for(String cc:cardsToValidate){
	    	 Map<String,Object> card = new HashMap<String,Object>();
	    	 card.put("card", cc);
	    	 card.put("isValid",isValid(cc));
	    	 card.put("isAllowed",isAllowed(bannedPrefixes,cc));
	    	 
	    	 validatedCards.add(card);
	     }
        return validatedCards;
    }
public static void main(String[] args) {
	// TODO Auto-generated method stub
	CreditCardValidation t2 = new CreditCardValidation();
	String[] bp = {"1034,5,993934,33,9"};
	String[] cc = {"3227366834142385"};
	
	System.out.println(cc[0]+" isValid = "+isValid(cc[0])+" isAllowed = "+isAllowed(bp,cc[0]));
	/*
	System.out.println(isValidCreditCard(cc[0]));
	
	 List<Map<String, Object>> map = validateCards(bp,cc);
	 
	 map.forEach(m->{
		 m.forEach((k,v)->{System.out.println(k+" = "+v);});
	 });*/
	
}

}
