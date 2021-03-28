package com.bitguiders.bjt_01._collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.bitguiders.util.io.PrintUtil;


public class CollectionVsCollections {
	

	public static void synchronizedList(Collection<String> list){
		PrintUtil.printTitle("synchronizedList");
		PrintUtil.printBefore(list);
		list =   Collections.synchronizedCollection(list);
		PrintUtil.printAfter(list);
	}
	
	public static void unmodifiableCollection(Collection<String> list) {
		PrintUtil.printTitle("unmodifiableCollection");
		PrintUtil.printBefore(list);
		
		list = Collections.unmodifiableCollection(list);
		
		System.out.println("Adding Abdul Saboor after read only");
		try{
			list.add("Abdul Saboor");
			
			}catch(UnsupportedOperationException ex) 
		{
			System.out.println(ex.toString());
		}
		PrintUtil.printAfter(list);
	}
	public static void reverse(List<String> list) {
		PrintUtil.printTitle("reverse");
		PrintUtil.printBefore(list);
		Collections.reverse(list);
		PrintUtil.printAfter(list);
	}
	public static void descendingSort(List<String> list) {
		PrintUtil.printTitle("descendingSort");
		PrintUtil.printBefore(list);
		Collections.sort(list,Collections.reverseOrder());
		PrintUtil.printAfter(list);
	}
	public static void main(String arg[]){
		Collection<String> list = new ArrayList<>();
		list.add("Abdul Jabbar");
		list.add("Javed Amjed");
		
		synchronizedList(list);
		
		unmodifiableCollection(list);
		descendingSort((List<String>)list);
		reverse((List<String>) list);
	}
}
