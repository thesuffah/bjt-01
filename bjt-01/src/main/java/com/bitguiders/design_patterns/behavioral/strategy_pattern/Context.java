package com.bitguiders.design_patterns.strategy_pattern;

public class Context {
	 Shape shape;
	public Context(Shape shape){
		this.shape = shape;
	}
	
	public void draw(){
		shape.draw();
	}
}
