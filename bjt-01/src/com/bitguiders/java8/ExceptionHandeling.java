package com.bitguiders.java8;

public class ExceptionHandeling {
	public static String tryCatchScope(){
		try {
		Thread.sleep(10);
		throw new InterruptedException();
		} catch (InterruptedException e) {
		System.out.print("-catch ");
		//System.exit(0); //program will exit immediately and finally will not execute
		return "catch ";//this will not execute
		}finally{
		System.out.print ("-finally ");
		return "finally ";
		}
		}
		public static void main(String[] args) {
		System.out.print(tryCatchScope());
		}
	
}
