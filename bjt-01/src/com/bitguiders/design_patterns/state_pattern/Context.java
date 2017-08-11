package com.bitguiders.design_patterns.state_pattern;

public class Context {
	State state;

	public void setState(State state) {
		this.state = state; 
	}
	
	public State getState(){
		return this.state;
	}
}
