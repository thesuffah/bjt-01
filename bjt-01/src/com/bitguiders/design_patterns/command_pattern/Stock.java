package com.bitguiders.design_patterns.command_pattern;

public class Stock {
	public String name="Think Pad T420";
	public int    quantity=10;
	public void buy(){
		System.out.println("Stock [ Name: "+name+",	Quantity: " + quantity +" ] bought");
		}
		public void sell(){
		System.out.println("Stock [ Name: "+name+",	Quantity: " + quantity +" ] sold");
		}
	
	
}
