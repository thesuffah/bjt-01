package com.bitguiders.util.io;

import java.util.Collection;

public class PrintUtil {
	public static void printTitle(String title) {
		for(int i=0;i<title.length();i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println(title);
		for(int i=0;i<title.length();i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	public static void printBefore(Collection<String> list) {
		System.out.println("@Before:"+list+" ,Type:"+list.getClass().getName());
	}
	public static void printAfter(Collection<String> list) {
		System.out.println("@After:"+list+" ,Type:"+list.getClass().getName());
	}
}
