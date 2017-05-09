package com.bitguiders.problems;

public class _StringPatterns {


	public static boolean isCorrect(char c1,char c2){
		//System.out.println(c1+" vs "+c2);
		if(c1=='{' && c2=='}'){
			return true;
		}else if(c1=='[' && c2==']'){
			return true;
		}if(c1=='(' && c2==')'){
			return true;
		}else{
			return false;
		}
	}
	public static boolean searchPattern(String str){
		boolean isValid=false;
		
			if(str.trim().length()>=2){
				if(isCorrect(str.charAt(0),str.charAt(1))){
				str = str.substring(1, 2);
				isValid=true;
				} else if(isCorrect(str.charAt(0),str.charAt(str.length()-1))){
					isValid =true;
					str = str.substring(1, str.length()-1);
				}
				
			if(isValid && str.trim().length()>=2){
				isValid = searchPattern(str);
			}else{
				return isValid;
			}
			}
			return isValid;
	}
	public static void main(String[] args) {
		String[] str ={"[{()}]","{[)}","{}[]()"};
		for(String s:str){
		System.out.println(s+" = "+searchPattern(s));
		}
	}

}
