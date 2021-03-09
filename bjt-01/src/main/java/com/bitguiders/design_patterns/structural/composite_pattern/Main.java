package com.bitguiders.design_patterns.composite_pattern;

public class Main {

	public static void print(Employee e){
		System.out.println(e.toString());
		for(Employee se:e.getSubOrdinates()){
			print(se);
		}
	}
	
	public static void main(String[] args) {
		Employee ceo = new Employee("Abdul Kareem","CEO",3000);
		
		Employee headSales = new Employee("Sohail","Sales",2000);
		Employee headMarketing = new Employee("Waqas","Marketing",2000);
		
		Employee salesExecutive1 = new Employee("Kashif","Sales",1000);
		Employee salesExecutive2 = new Employee("Rashid","Sales",1000);
		
		Employee marketingExecutive1 = new Employee("Amir","Marketing",1000);
		Employee marketingExecutive2 = new Employee("Wajid","Marketing",1000);
		
		ceo.add(headSales);
		ceo.add(headMarketing);
		
		headSales.add(salesExecutive1);
		headSales.add(salesExecutive2);
		
		headMarketing.add(marketingExecutive1);
		headMarketing.add(marketingExecutive2);
		
		print(ceo);
	}

}
