package com.bitguiders.design_patterns.observer_pattern;

public class Main {

		public static void main(String[] args) {
		Subject subject = new Subject();
		new AObserver(subject);
		new BObserver(subject);
		new CObserver(subject);
		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);
		}

}
