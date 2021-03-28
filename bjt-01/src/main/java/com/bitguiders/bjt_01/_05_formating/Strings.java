package com.bitguiders.bjt_01._05_formating;

//String is final class So, can't extend it
public class Strings //extend String
{

	public static void main(String[] args) {
		//s1 and s2 both refers single object in Heap.
		String s1= "v1";//new object created
		String s2= "v1";//it will refer s1 in Heap, as text is same
		String s3= new String("v1");//new object
		
		System.out.println(s1==s2);

		//values are same then why s1==s3 returned false..? its comparing references not values
		System.out.println(s1==s3);
		
		System.out.println(s1.equals(s3));
		
	}

}
