package com.bitguiders.problems;

public class MyRegex {
	 private static String pattern = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
	    private String ip;
	    public MyRegex(String iP) { 
	        this.ip=ip;
				System.out.println(isMatch());
			
	    }
	    
	    public boolean isMatch() {
	        return ip.matches(pattern);
	    }
	public static void main(String[] args) {
		
	}
}
