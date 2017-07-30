package com.bitguiders.problems.cambridge;

public class Solution0 {

	   public int solution(int[] A) {
		   if (A.length==0  || A.length>100000) return -1; 
		     int sum = 0;
		    
		    for(int i=0;i<A.length;i++) 
		    	sum+= A[i]; 

		    int sum_left = 0;    
		    for(int i=0;i<A.length;i++) {
		        int sum_right = sum - sum_left -  A[i];
		        if (sum_left == sum_right) return i;
		        sum_left +=  A[i];
		    } 
		    return -1; 
	    }
	public static void main(String[] args) {
		
		int[] v  = {-1, 3, -4, 5, 1, -6, 2, 1};
		Solution0 s = new Solution0();
		
		System.out.println(s.solution(v));
		
		

	}

}
