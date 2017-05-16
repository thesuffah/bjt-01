package com.bitguiders.bjt_01;

//https://en.wikibooks.org/wiki/Java_Programming/Literals
public class Literals {

	public static void main(String[] args) {
		int one = '1';
		int zero= '0';
		
		System.out.println("120..? " + one + '2'+zero);

		System.out.println("null..? \0 \\"+zero);
		
		Integer i1=2;//boked
		Integer i2=2;//bokex
		int i3 = i2;//unboxed
		System.out.println(i1==i2);
		System.out.println(i1==i3);
	}

}
