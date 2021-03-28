package com.bitguiders.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {
	 private static String pattern = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
	    private String ip;
	   
	    /*
	     * 	    	String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
	    	        "(?<mastercard>5[1-5][0-9]{14})|" +
	    	        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
	    	        "(?<amex>3[47][0-9]{13})|" +
	    	        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
	    	        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

	     */
	   
	    
	    public boolean isValidCreditCard(String cc){
	    	String regex = "^((4[0-9]{15})|(5[0-9]{15})|(6[0-9]{15})"
	    			+"|(4[0-9]{3}-[0-9]{4}-[0-9]{4}-[0-9]{4})"
	    			+"|4[0-9]{3} [0-9]{4} [0-9]{4} [0-9]{4}"
	    			+ ")";
	    	Matcher m = Pattern.compile(regex).matcher(cc);
	    	
	    	return m.find(); 
	    }
	public static void main(String[] args) {
		MyRegex r = new MyRegex();
		/*
		 * 4123456789123456
5123-4567-8912-3456
61234-567-8912-3456
4123356789123456
5133-3367-8912-3456
5123 - 3567 - 8912 - 3456
		 */
		
		String[] cc = {
				"4123456789123456"
				,"4123-4567-8912-3456"
				,"4123 4567 8912 3456"
				,"4123"
				,"412345678912345J"
				,"5123456789123456"
				,"6123456789123456"
				,"3123456789123456"
				
		};
		
		for(String c:cc)
		System.out.println(c+" : "+(r.isValidCreditCard(c)?"Valid":"Invalid"));
		
	}
}
