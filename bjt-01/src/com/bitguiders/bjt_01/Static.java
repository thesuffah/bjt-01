package com.bitguiders.bjt_01;

//import static ClassName.*;
public class Static {
	   int a=5;
	static{
		System.out.println("Static block: Who called me..?");
	}
	{
		System.out.println("Non Static block: Who called me..?");
	}
	public static synchronized void main(String... arg) {
		
		new Static();
		test();
	}
	static public void test(){
		System.out.println("static public void order changed");
	}
   
}
