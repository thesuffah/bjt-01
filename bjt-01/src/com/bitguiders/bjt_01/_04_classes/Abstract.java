package com.bitguiders.bjt_01._04_classes;

public  abstract class Abstract {
	public abstract void abstractMethod();
	private void abstractMethod1(){
		System.out.println("abstractMethod1");
	}
}
 abstract class Abstract2 extends Abstract{}
 
class Run extends Abstract2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Abstract c = new Run();
		c.abstractMethod();
		
		
	}

	@Override
	public void abstractMethod() {
		System.out.println("abstractMethod");
	}
}