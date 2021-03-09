package com.bitguiders.design_patterns.strategy_pattern;

public class Main {

	public static void main(String[] args) {
		Context line      = new Context(new Line());
		Context circle    = new Context(new Circle());
		Context rectangle = new Context(new Rectangle());
		Context triangle  = new Context(new Triangle());
		
		line.draw();
		circle.draw();
		rectangle.draw();
		triangle.draw();
	}

}
