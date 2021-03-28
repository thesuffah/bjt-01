package com.bitguiders.bjt_01._04_classes;

class Parent{
	public void a(){}
	public static void b(){}
}
class Child extends Parent{
	@Override
	public void a(){}
	public static void b(){}
	
	//public int a(){return 0;}
	public void a(int a){}//overloading
	public void a(int a,int b){}//overloading
	
	
}
public class OverridingNLoading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
