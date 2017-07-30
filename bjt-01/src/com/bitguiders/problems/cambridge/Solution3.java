package com.bitguiders.problems.cambridge;

class Solution3 {
	
	int solution_(int[] A, int K){
		int divisible = K*K;
		for(int i=0;i<A.length;i++){
			if(A[i]> divisible ){
			  //System.out.println(A[i]+"= " +A[i]%2);
				return A[i];
			}
		}
		
		return 2;
	}
    int solution(int[] A, int K) {
        int n = A.length;
        int best = 0;
        int count = 1;
        for (int i = 0; i < n - K - 1; i++) {
            if (A[i] == A[i + 1])
                count = count + 1;
            else
                count = 0;
            if (count > best)
                best = count;
        }
        int result = best + 1 + K;

        return result;
    }
    
	public static void main(String[] arg){
		Solution3 s = new Solution3();
		
		int a[] = {1,1,3,3,3,4,5,5,5,5};
		System.out.println(s.solution(a,2));
	}

}