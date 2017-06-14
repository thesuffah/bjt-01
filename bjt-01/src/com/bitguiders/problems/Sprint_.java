package com.bitguiders.problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Sprint_ {

	static boolean isValid(int n){
		boolean valid=false;
		if(1<=n && n<=100000){
			valid = true;
		}
		return valid;
	}
	static int getMostVisited(Map<Integer,Integer> sprintCount){
		int mostVisited=0;
		int index=0;
		
		for(Integer i:sprintCount.keySet()){
			//System.out.println(i+" = "+sprintCount.get(i));
			if(sprintCount.get(i)>mostVisited){
				mostVisited = sprintCount.get(i);
				index=i;
			}else if(mostVisited==sprintCount.get(i) && i<index){
				index =i;
			}
		}
		return index;
	}
	static int getMostVisited(int n, int[] sprints) {
		
		if(!isValid(n)){
			return 0;
		}
		
		int fromSprint=0;
		int toSprint=1;
		
		Map<Integer,Integer> sprintCount = new TreeMap<Integer,Integer>(); 
		for(int j=0;j<sprints.length-1;j++){
			
			fromSprint = sprints[j];
			toSprint = sprints[j+1];
			if(fromSprint>toSprint){
				//swap
				toSprint = sprints[j];
				fromSprint = sprints[j+1];
			}
			//System.out.print(fromSprint+"->"+toSprint+" :");
			
			for(int i=fromSprint;i<=toSprint;i++){
				//System.out.print(i+",");
				if(!sprintCount.containsKey(i)){
					sprintCount.put(i, 1);
				}else{
					sprintCount.put(i, sprintCount.get(i)+1);
				}
			}
			//System.out.println("");
		}
		return getMostVisited(sprintCount);
	}
	public static void main(String arg[]){
		int n=10;
		int sprints[] = {1,3,5,10,3};
		int v = getMostVisited(n,sprints);
		System.out.println(v);
	}
	public static void main_(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = "D:\\workspaces\\bitguiders\\training\\bjt-01\\bjt-01\\src\\com\\bitguiders\\problems\\output.txt";//System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
        
        
        int _sprints_size = 0;
        _sprints_size = Integer.parseInt(in.nextLine().trim());
        int[] _sprints = new int[_sprints_size];
        int _sprints_item;
        for(int _sprints_i = 0; _sprints_i < _sprints_size; _sprints_i++) {
            _sprints_item = Integer.parseInt(in.nextLine().trim());
            _sprints[_sprints_i] = _sprints_item;
        }
        
        res = getMostVisited(_n, _sprints);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }
}
