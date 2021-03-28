package com.bitguiders.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazaonShoppingOptions {
    int balance=0;
    List<Integer> shopingCart = new ArrayList<>();
    
	public int numberOfOptions(List<Integer> shoeOptions,int totalBudget,int noOfItems) {
		int noOfOptions=0;
		balance=totalBudget;
		
		Collections.sort(shoeOptions);
		for(int i=0;i<noOfItems;i++) {
			if(shoeOptions.size()>=i && balance>=shoeOptions.get(i)) {
				balance -=shoeOptions.get(i);
				noOfOptions++;
				shopingCart.add(shoeOptions.get(i));
			}
		}
		
		return noOfOptions;
	}
	
	public int getNumberOfOptions(int totalBudget,List<Integer>... options) {
		int noOfOptions=0;
		balance = totalBudget;
		for(List<Integer> option: options) {
			noOfOptions +=numberOfOptions(option,balance,2);
		}
		return noOfOptions;
	}
	public static void main(String arg[]) {
		System.out.println("start");
		
		AmazaonShoppingOptions amazaonShoppingOptions = new AmazaonShoppingOptions();
		
		int totalBudget=10;
		int noOfOptions=0;
		
		ArrayList<Integer> shoeOptions = new ArrayList<>();
		shoeOptions.add(2);
		shoeOptions.add(6);
		shoeOptions.add(3);
		shoeOptions.add(7);
		
		ArrayList<Integer> skirtOptions = new ArrayList<>();
		skirtOptions.add(2);
		skirtOptions.add(4);
		
		ArrayList<Integer> socksOptions = new ArrayList<>();
		socksOptions.add(3);
		socksOptions.add(1);

		
		noOfOptions += amazaonShoppingOptions.getNumberOfOptions(totalBudget, shoeOptions,skirtOptions,socksOptions);
		System.out.println("Input: shoe:"+shoeOptions+",skits:"+skirtOptions+",socks:"+socksOptions);
		System.out.println("Options: "+noOfOptions+", "+amazaonShoppingOptions.shopingCart);
		System.out.println("totalBudget:"+totalBudget+", balance:"+amazaonShoppingOptions.balance);
	}
}
