package com.bitguiders.bjt_01._04_classes;

interface AI { public void method1();}
interface BI { public void method2();}
interface CI extends AI,BI {}

public class Interface_ implements CI {

	@Override
	public void method1() {	System.out.println("method1");}

	@Override
	public void method2() {	}

	public static void main(String[] arg) {
		Interface_ i = new Interface_();
		AI ai = new Interface_();
		BI bi = new Interface_();
		CI ci = new Interface_();
		i.method1();
		ai.method1();
		//bi.method1(); it will not work
		ci.method1();
		System.out.println("Can we extend more than one interfaces..?");
	}

	
}
