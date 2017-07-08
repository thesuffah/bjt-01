package com.bitguiders.design_patterns.observer_pattern;

	public class CObserver extends Observer{
		public CObserver(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
		}
		@Override
		public void update() {
		System.out.println( "CObserver String: "
		+ Integer.toOctalString( subject.getState() ) );
		}
		}
