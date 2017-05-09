/*package com.bitguiders.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambdas implements Functional {
	public static void main(String arg[]){
		//example 1
		List<String> array = new ArrayList<String>();
		array.add("ab");
		array.add("a");
		array.add("abc");
		array.forEach(e -> System.out.println(e));
		
		//sorting
		array.sort((e1,e2)->e1.compareTo(e2));
		//more print options
		array.forEach(e -> {
			String str = e+" length = "+e.length();
			System.out.println(str);
			});
		
		//example 2
		Arrays.asList( "a", "b", "c" ).forEach( e -> System.out.println( e ) );

		Functional functional = new Lambdas();
		functional.defaultMethod();
		functional.test();

	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}
}
*/