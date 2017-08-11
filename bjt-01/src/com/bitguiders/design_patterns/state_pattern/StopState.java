package com.bitguiders.design_patterns.state_pattern;

public class StopState implements State {

	public void doAction(Context context) {
		System.out.println("Player is in stop state");
		context.setState(this);
		}
		public String toString(){
		return "Stop State";
		}

}
