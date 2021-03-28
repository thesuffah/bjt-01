package com.bitguiders.bjt_01._04_classes;

interface AI { int a=1; public void method1(int a);}
interface BI { int a=2;public void method2();}
interface CI extends AI,BI { class B{ int a=3; B(){System.out.println("Class inside of interface");}}}

public class Interface_ implements CI {

	@Override
	public void method1(int a) {	System.out.println("method1 a="+a);}

	@Override
	public void method2() {	}

	public static void main(String[] arg) {
		Interface_ i = new Interface_();
		AI ai = new Interface_();
		BI bi = new Interface_();
		CI ci = new Interface_();
		i.method1(1);
		ai.method1(ai.a);
		//bi.method1(); it will not work
		ci.method1(bi.a);
		CI.B b = new CI.B();
		
		System.out.println("Can we extend more than one interfaces..?");
	}

	
}
