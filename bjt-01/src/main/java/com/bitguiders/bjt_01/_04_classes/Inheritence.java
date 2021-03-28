package com.bitguiders.bjt_01._04_classes;

class           A{int a=1; A(){System.out.println("A this.a="+this.a);} String a(){return " Parent A";}}
class B extends A{int a=2; B(){System.out.println("B this.a="+this.a+" super.a="+super.a);} String a(){return " Child  B";}}
class C extends B{int a=3; C(){System.out.println("C this.a="+this.a+" super.a="+super.a);} String a(){return " Child  C";}}

public class Inheritence {

	public static void main(String[] args) {
		A c =new C();
		System.out.println("a ="+c.a+c.a());
	}
}
 