package com.bitguiders.problems.hacker_rank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PersonalizedCoupons {


  	static List<Map<String,Object>> personalizeCoupons(List<Map<String,Object>> coupons, List<String> preferredCategories){
		
		List<Map<String,Object>> filteredCupons = new ArrayList<Map<String,Object>>();
		//Step-1: Filter out all coupons that are not in the list of preferred categories.
		for(Map<String,Object> map: coupons){
			if(preferredCategories.contains(map.get("category"))){
				//System.out.println("This item doesn't exists = "+map.get("category"));
				filteredCupons.add(map);
			}
		}
		
		
		//Step-2: Sort the coupons by the percentage off (highest first).
		Collections.sort(filteredCupons,(m1,m2)-> ((Float) m2.get("couponAmount")).compareTo((Float) (m1.get("couponAmount"))));
		
		//Step-3: Only keep the first 10.
		if(filteredCupons.size()>10)
		filteredCupons = filteredCupons.subList(0,2);
		
		filteredCupons.forEach(m->{
			m.remove("code");
		});
		return filteredCupons;
		
	}
	public static void printCoupon(Map<String, Object> coupon) {
		System.out.print("{");
		System.out.println("\"couponAmount\":" + coupon.get("couponAmount") + ",");
		System.out.println("\"upc\":" + coupon.get("upc") + ",");
		if(coupon.containsKey("code")) {
			System.out.println("\"code\":" + coupon.get("code") + ",");
		}
		System.out.println("\"itemPrice\":" + coupon.get("itemPrice") + ",");
		System.out.println("\"category\":" + coupon.get("category") + "\"}");
	}



	
	public static Map<String, Object> readCoupon(Scanner input){
		String[] couponItems = input.nextLine().split(",");
		Map<String,Object> coupon = new HashMap<>();
		coupon.put("upc",couponItems[0]);
		coupon.put("code",couponItems[1]);
		coupon.put("category",couponItems[2]);
		coupon.put("itemPrice",Float.parseFloat(couponItems[0]));
		coupon.put("couponAmount",Float.parseFloat(couponItems[0]));
		return coupon;
	}
	
public static void main(String[] args) throws IOException{
	
	List<String> preferredCategories = new ArrayList<String>();
	preferredCategories.add("Baby");
	preferredCategories.add("Gift Cards");
	//preferredCategories.add("Sporting Goods");
	preferredCategories.add("Photo Shop");
	preferredCategories.add("Deli");
	preferredCategories.add("Baking Goods");
	//preferredCategories.add("International");
	
	
	List<Map<String,Object>> coupons = new ArrayList<Map<String,Object>>();
	
	Map<String,Object> c1 = new HashMap<String,Object>();
	c1.put("upc","4816683327672908");
	c1.put("code","39385271820845634478");
	c1.put("category","Gift Cards");
	c1.put("itemPrice","17.72");
	c1.put("couponAmount","6.61");
	//{"couponAmount":6.61,"upc":"4816683327672908","itemPrice":17.72,"category":"Gift Cards"}
	coupons.add(c1);

	Map<String,Object> c2 = new HashMap<String,Object>();
	c2.put("upc","3663405873668696");
	c2.put("code","26761211143034934597");
	c2.put("category","International");
	c2.put("itemPrice","11.75");
	c2.put("couponAmount","4.91");
	coupons.add(c2);

	Map<String,Object> c3 = new HashMap<String,Object>();
	c3.put("upc","0677335752583272");
	c3.put("code","26761211143034934597");
	c3.put("category","Sporting Goods");
	c3.put("itemPrice","10.97");
	c3.put("couponAmount","5.02");
	coupons.add(c3);
		// total/obtained*100
	personalizeCoupons(coupons,preferredCategories).forEach(m->{
		System.out.println(m);
	});
	/*Scanner input = new Scanner(System.in);
	List<String> preferredCategories = Arrays.asList(input.nextLine().split(","));
	List<Map<String,Object>> coupons = new ArrayList<>();
	int lines = Integer.parseInt(input.nextLine());
	IntStream.range(0,  lines).forEach(i-> coupons.add(readCoupon(input)));
	List<Map<String,Object>> personalizedCoupons = personalizeCoupons(coupons, preferredCategories);
	personalizedCoupons.stream().forEach(PersonalizedCoupons::printCoupon);;*/
}

	

}
