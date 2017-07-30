package com.bitguiders.problems.cambridge;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
	
	Map<String,Integer> distanceMap = new HashMap<String,Integer>();
	{
		//calculate distance
		String city[] =               {"19","13","17","10","14","18","12","15","16","93","97","90","98","94","92","95","96","08","04","05","02","06","45","42","86","84","85","82","37","30","34","38","74","78","35","32","36","75","72","76"};
		int calculatedDistance[] = {1,2,2,2,3,3,4,4,4,1,1,1,2,2,3,3,3,1,1,2,2,2,1,1,1,2,3,3,2,2,3,3,3,3,4,4,4,4,4,4};
		for(int i=0;i<city.length;i++){
			distanceMap.put(city[i], calculatedDistance[i]);
		    distanceMap.put((new StringBuilder(city[i]).reverse().toString()), calculatedDistance[i]);
		}
	}
    int[] solution(int[] A) {
    	int[] distances = new int[A.length];
    	
    	for(int i=0;i<A.length-1;i++){
    		if(distanceMap.containsKey(A[i]+""+A[i+1])){
    		distances[i] = distanceMap.get(A[i]+""+A[i+1]);
    		}else{
    			System.out.println(A[i]+""+A[i+1]);
    			distances[i] = A[i];
    		}
    	}
    	return distances;
    }   
	public static void main(String[] arg){
		Solution1 s = new Solution1();
		int ip[] = {9, 1, 4, 9, 0, 4, 8, 9, 0, 1};
		//{1, 3, 2, 3, 0, 0, 0, 0}
		int result[] = s.solution(ip);
		for(int i=0;i<result.length;i++){
		  System.out.println(ip[i]+" = "+result[i]);
		}
	}
}
