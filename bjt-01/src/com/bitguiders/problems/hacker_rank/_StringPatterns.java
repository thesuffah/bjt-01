package com.bitguiders.problems.hacker_rank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class _StringPatterns {


	public static boolean isValid(String s){
		
		s = Pattern.compile("\\(\\)").matcher(s).replaceAll("");
		s = Pattern.compile("\\{\\}").matcher(s).replaceAll("");
		s = Pattern.compile("\\[\\]").matcher(s).replaceAll("");
		
		return (s.length()==0?true:false);
	}
	 
    static String[] braces(String[] values) {
    	String result[] = new String[values.length];
    		for(int i=0;i<values.length;i++){
    			result[i] = (isValid(values[i])?"YES":"NO");
    		}
    	return result;
    }

	public static void main(String[] args) {
		String[] str ={"[{()}]","{[)}","{}[]()","123KL"};
		for(String s:str){
		System.out.println(s+" = "+isValid(s));
		}
		
		for(String s:braces(str)){
			System.out.println(s);
		}
	}

	 public static void main_(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        final String fileName = System.getenv("OUTPUT_PATH");
	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	        String[] res;
	        //{"[{()}]","{[)}","{}[]()","123KL"}
	        int _values_size = 0;
	        _values_size = Integer.parseInt(in.nextLine().trim());
	        String[] _values = new String[_values_size];
	        String _values_item;
	        for(int _values_i = 0; _values_i < _values_size; _values_i++) {
	            try {
	                _values_item = in.nextLine();
	            } catch (Exception e) {
	                _values_item = null;
	            }
	            _values[_values_i] = _values_item;
	        }
	        
	        res = braces(_values);
	        for(int res_i=0; res_i < res.length; res_i++) {
	            bw.write(String.valueOf(res[res_i]));
	            bw.newLine();
	        }
	        
	        bw.close();
	    }
}
