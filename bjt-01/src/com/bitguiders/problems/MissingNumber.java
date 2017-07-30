package com.bitguiders.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MissingNumber {

	public static List<Integer> findMissingNumbers(int[] arr){
		List<Integer> missingNumbers = new ArrayList<Integer>();
		
		Arrays.sort(arr);
		
		int missingCount=0;
		int previousValue=arr[0];
		
		for(int i=1;i<arr.length;i++){
			//System.out.print(arr[i]+",");
			System.out.println(arr[i]-1+" vs "+arr[i-1]);
			
			if(arr[i]-1!=previousValue){
				System.out.println("Y Missing="+(previousValue+1));
				missingNumbers.add(previousValue+1);
			}
			previousValue = arr[i];
			
		}
		
		return missingNumbers;
	}
	
	public static void main(String[] arg){
		int[] arr = {2,5,7,3,8};
		          //{2,3,4,5,6,7,8,9}
		findMissingNumbers(arr).forEach(n->System.out.print(n+","));
	}
}
