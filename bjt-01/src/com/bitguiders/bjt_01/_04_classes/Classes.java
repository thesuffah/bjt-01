package com.bitguiders.bjt_01._04_classes;


class OuterClass{
	class InnerClass{
		public  InnerClass(){
			System.out.println(" - "+this.getClass().getSimpleName());
		}
	}
	static class StaticInnerClass{
		public StaticInnerClass(){
			System.out.println(" - "+this.getClass().getSimpleName());
		}
	}
	public OuterClass(){
		System.out.println(this.getClass().getSimpleName());
		
		class LocalClass{
			public LocalClass(){
				System.out.println(" - "+this.getClass().getSimpleName());
			}
		}
		
		new LocalClass();
		
		LocalClass anonyomusClass = new LocalClass(){
			{
				System.out.println(" - "+this.getClass().getSimpleName());
			}
		};
		
	}
	
	
}
public class Classes {

	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		OuterClass.InnerClass innerClass = outerClass.new InnerClass();
		OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
	}

}