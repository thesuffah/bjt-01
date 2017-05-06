package com.bitguiders.bjt_01;

public final class Finals {

	//final int a;
	final String finalVariable="bitguiders";
	final static String finalStatic="";
	public Finals(){
		System.out.println("FinalClass");
	}
	
	public final void finalMethod(String str){
		System.out.println("finalMethod "+str);
	}
	
	public static void main(String[] arg){
		Finals finals = new Finals();
		finals.finalMethod(finals.finalVariable);
	}
}
