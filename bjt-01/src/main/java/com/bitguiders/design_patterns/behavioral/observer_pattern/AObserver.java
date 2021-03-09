package com.bitguiders.design_patterns.observer_pattern;

	public class AObserver extends Observer{
		public AObserver(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
		}
		@Override
		public void update() {
		System.out.println( "AObserver String: "
		+ Integer.toOctalString( subject.getState() ) );
		}
	}
