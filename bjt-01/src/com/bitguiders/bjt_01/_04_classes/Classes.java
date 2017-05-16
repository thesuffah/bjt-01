package com.bitguiders.bjt_01._04_classes;


class OuterClass{
	int a=2;
static	int b=2;
	//Member inner Class, inside of class and outside of method :)
	class InnerClass{
		public  InnerClass(){
			System.out.println(" - "+this.getClass().getSimpleName()+" a= "+a);
		}
	}
	static class StaticInnerClass{
		public StaticInnerClass(){
			System.out.println(" - "+this.getClass().getSimpleName()+" b= "+b);
		}
	}
	public OuterClass(){
		System.out.println(this.getClass().getSimpleName());
		
		//defined inside of method
		class LocalClass{
			public LocalClass(){
				System.out.println(" - "+this.getClass().getSimpleName()+" a= "+a);
			}
		}
		
		new LocalClass();
		
		LocalClass anonyomusClass = new LocalClass(){
			{
				System.out.println(" - "+this.getClass().getSimpleName()+" a= "+a);
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