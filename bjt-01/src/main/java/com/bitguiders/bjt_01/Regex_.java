package com.bitguiders.bjt_01;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Regex_ {

	public boolean isValid(String regex,String input){
		return Pattern.compile(regex).matcher(input).find();
	}
	public void verify(String regex,String input,String comments){
		System.out.println("Regex = "+regex
				+", Input ="+input
				+", is Valid = "+ (isValid(regex,input)?"Yes":"No ")
				+", //"+comments
				);
	}
	public static void main(String[] args) {
		Regex_ r = new Regex_();
		
		
		r.verify("[0-9]","1a","should contain at least one number");
		r.verify("[0-9]","ab","should contain at least one number");

		r.verify("[a-z]","aB3","should contain at leas one small Letter");
		r.verify("[a-z]","AB3","should contain at leas one small Letter");

		r.verify("[A-Z]","aB3","should contain at leas one Capital Letter");
		r.verify("[A-Z]","ab3","should contain at leas one Capital Letter");

		r.verify("^[0-9]","1a","strat with numbers only");
		r.verify("^[0-9]","a1","start with numbers only");

		//^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$
		//r.verify(".[0-9]","1aB","at least one smal,one Cap and one number required");
		//r.verify("(?=[0-9])","Bb1","at least one smal,one Cap and one number required");
	}

}
