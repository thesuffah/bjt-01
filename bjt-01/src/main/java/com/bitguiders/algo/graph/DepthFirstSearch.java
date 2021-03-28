package com.bitguiders.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DepthFirstSearch {

	Map<String,String[]> graph = new HashMap<String,String[]>();
	Map<String,String[]> discovered = new HashMap<String,String[]>();
	ArrayList<String> discoveredTrack = new ArrayList<String>();
	int index=0;
	
	public void addVertices(String vertic,String... neighbors) {
		graph.put(vertic, neighbors);
	}
	public void printGraph(Map<String,String[]> graph) {
		
		graph.forEach((k,v)->{
			System.out.print("\n"+k+":{");
			int counter = v.length-1;
			for(String neighbor:v) {System.out.print(neighbor+(counter-- !=0?",":"}"));}
			
		});
	}
	public void printTrack(String startWith,String[] neighbors) {
		
			System.out.print("\n"+startWith+":{");
			int counter = neighbors.length-1;
			for(String neighbor:neighbors) {System.out.print(neighbor+(counter-- !=0?",":"}"));}
	}
	public ArrayList<String> search(Map<String,String[]> graph,String startingVertic) {
		
		//check if its already discovered
		if(discovered.containsKey(startingVertic)) {return discoveredTrack;}
		
		
		//get neighbors for next level search
		String[] neighbors= graph.get(startingVertic);
		Arrays.sort(neighbors);
		
		//mark as discovered
		discovered.put(startingVertic, graph.get(startingVertic));
		graph.remove(startingVertic);

		//discover neighbor vertices in alphabetical asc order A,B,C.. etc
		for(String nextNeighbor:neighbors) {
			if(!discovered.containsKey(nextNeighbor)) {
			 printTrack(startingVertic+(index++)+"->"+nextNeighbor+index,neighbors);
			 discoveredTrack.add(startingVertic+nextNeighbor);
			 
			 search(graph,nextNeighbor);
			}
		}
		return discoveredTrack;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.addVertices("A", "F","C","G");
		dfs.addVertices("B", "F","C","D");
		dfs.addVertices("C", "F","A","G","E","D");
		dfs.addVertices("D", "B","C","E");
		dfs.addVertices("E", "D","C","G");
		dfs.addVertices("F", "A","B","C");
		dfs.addVertices("G", "A","C","E");
		
		System.out.println("Depth First Search");
		System.out.println(dfs.search(dfs.graph, "B"));
		
		//System.out.println("\nVisited Graph");
		//dfs.printGraph(dfs.discovered);
		
	}

}
