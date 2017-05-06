package com.bitguiders.bjt_01;

public class CovariantReturnType {

	 public CovariantReturnType get(){
		 System.out.println("Parent get is called");
		 return this;
	 }
	public static void main(String[] args) {
		new Child().get();
	}

}
class Child extends CovariantReturnType{
	public Child get(){
		System.out.println("Child get is called");
		return this;
	}
}
