package com.bitguiders.design_patterns.creational;

/*
 *  Singelton examples from java
    Java.lang.Runtime with getRuntime() method 
    Java.awt.Toolkit with getDefaultToolkit() 
    Java.awt.Desktop with getDesktop() 

 */
public class Singleton implements Cloneable {
	static int counter=0;
	private static  Singleton _INSTANCE = new Singleton();
	//static int counter=0; //in this case, counter will not give you correct result :)
	
	
	public static Singleton getInstance(){
		
		//double check should use in case of lazy initialization only
		if(_INSTANCE == null){
	         synchronized(Singleton.class){
	         //double checked locking - because second check of Singleton instance with lock
	                if(_INSTANCE == null){
	                    _INSTANCE = new Singleton();
	                }
	            }
	         }
	     return _INSTANCE;
	}
	private  Singleton(){
		++counter;
		System.out.println("Constructor called");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
class Run {
	public static void main(String arg[]) throws CloneNotSupportedException{
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = (Singleton) s2.clone();
		System.out.println("Total Constructor calls = "+Singleton.counter);
	}
}
