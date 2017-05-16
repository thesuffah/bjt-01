package com.bitguiders.bjt_01._collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorVsListIterator {
	public static void iterate(){
		System.out.println("\nIterator\n");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("c");
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("forward->");
		//forward
		ListIterator listIterator = list.listIterator();
		while(listIterator.hasNext()){
				System.out.println(listIterator.next());
		}
		System.out.println("<-Backward ");
		//backward
		while(listIterator.hasPrevious()){
			System.out.println(listIterator.previous());
	}

	}

	public static void main(String[] args) {
		iterate();
	}

}
