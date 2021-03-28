package com.bitguiders.problems;

import java.util.Scanner;

/*public class Main extends Static {

	public static void main(String[] arg){
		Object obj;
		Class c;
	}
	
}*/
public final class Test4 {
	public int divide(int a, int b) {
	    int c = -1;
	    
	    try {
	        c = a / b;
	    } 
	    catch (Exception e) {
	        System.err.print("Exception ");
	    } 
	    finally {
	        System.err.println("Finally ");
	    }
	    
	    return c;
	}
	public static void main(String arg[]) throws Exception{
		Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int p= scanner.nextInt();
        if(n<0 || p<0){
            throw new Exception("java.lang.Exception: n and p should be non-negative");
        }
        
        int power =1;
        for(int i=0;i<p;i++){
            power =power*n;
        }
        System.out.println(power);
        
	}
   /*
	class Inner {
                void test() {
                        if (Test4.this.flag) {
                                sample();
                        }
                }
        }
        private boolean flag = true;
        public void sample() {
                System.out.println("Sample");
        }
        public Test4() {
                (new Inner()).test();
        }
        public static void main(String args []) {
                new Test4();
        }
        */
}