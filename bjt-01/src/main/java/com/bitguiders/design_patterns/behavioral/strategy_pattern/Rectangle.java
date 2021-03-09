package com.bitguiders.design_patterns.strategy_pattern;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Draw "+this.getClass().getSimpleName());
	}

}
