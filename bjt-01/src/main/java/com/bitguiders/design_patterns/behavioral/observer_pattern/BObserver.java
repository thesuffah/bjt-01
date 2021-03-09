package com.bitguiders.design_patterns.observer_pattern;

	public class BObserver extends Observer{
		public BObserver(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
		}
		@Override
		public void update() {
		System.out.println( "BObserver String: "
		+ Integer.toOctalString( subject.getState() ) );
		}
		}
