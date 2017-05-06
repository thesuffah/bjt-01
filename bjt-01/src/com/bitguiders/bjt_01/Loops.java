package com.bitguiders.bjt_01;

public class Loops {

	/*
	 *       *
	 *      **
	 *     ***
	 *    ****
	 */
	public void printTree1(int n){
		for(int i=0;i<=n;i++){
			System.out.println();
			for(int j=0;j<=n;j++){
					System.out.print((j<=n-i?" ":"*"));
			}
		}
	}
	public void printTree2(int n){
		for(int i=0;i<=n;i++){
			System.out.println();
			for(int j=0;j<=n;j++){
					System.out.print((j>=n-i?" ":"*"));
			}
		}
	}
	public void printTree3(int n){
		for(int i=1;i<=n;i++){
			System.out.println();
			for(int j=1;j<=i;j++){
					System.out.print("*");
			}
		}
	}
	public void printTree4(int n){
		for(int i=1;i<=n;i++){
			System.out.println();
			for(int j=0;j<=n-i;j++){
					System.out.print("*");
			}
		}
	}
	

	public static void main(String[] args) {
		Loops loop = new Loops();
		loop.printTree1(5);
		loop.printTree2(5);
		loop.printTree3(5);
		loop.printTree4(5);
	}

}
