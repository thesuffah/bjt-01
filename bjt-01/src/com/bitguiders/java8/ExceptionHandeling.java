package com.bitguiders.java8;

public class ExceptionHandeling {
	public static String tryCatchScope(){
		try {
		Thread.sleep(10);
		throw new InterruptedException();
		} catch (InterruptedException e) {
		System.out.print("-catch ");
		return "catch ";
		}finally{
		System.out.print ("-finally ");
		return "finally ";
		}
		}
		public static void main(String[] args) {
		System.out.print(tryCatchScope());
		}
	
}
