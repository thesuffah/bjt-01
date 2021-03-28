package com.bitguiders.java8;

@FunctionalInterface
 interface Functional {
	void method();
	
	default void defaultMethod(){
		System.out.println("I am from default method");
	}
	default void defaultMethod2(){
		System.out.println("I am from default method 2");
	}
}
public class FunctionalInterface_ implements Functional {
	public static void main(String arg[]){
		FunctionalInterface_ functionalInterface = new FunctionalInterface_();
		functionalInterface.defaultMethod();
		functionalInterface.defaultMethod2();
	}

	@Override
	public void method() {
		
	}
}