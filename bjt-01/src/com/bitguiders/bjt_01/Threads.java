package com.bitguiders.bjt_01;

class Thread1 implements Runnable{

	@Override
	public void run() {
		System.out.println("Running...");
	}
}

class ShutdownHook extends Thread{
	public void run(){System.out.println("Cleanup operation started, before app exit..");}
}

//strictfp at class level: implicitly applies on nested classes and methods.
public strictfp class Threads extends Thread {

	//every thread will read a from main memorey instead of its cached value.
	volatile int a=1;

	
	public void run(){
		 System.out.println("Name: "+Thread.currentThread().getName());  
		  System.out.println("Daemon: "+Thread.currentThread().isDaemon());  
		  System.out.println("State While running (t1) ="+getState());
		for(int i=1;i<=5;i++){  
			a=i;
			   try{  
			    //wait(500);//will release lock
			    //notify();//notify this waiting thread
			    //notifyAll();//will notify all waiting threads
				Thread.sleep(500);  //will not release lock
			   }catch(InterruptedException  e){System.out.println(e);}  
			  System.out.println(i);  
			  }  
	}
	
	//strict floating point on cross platform env, ensure percision values will be same
	//on all systems.
	public static synchronized strictfp  void main(String[] args) throws InterruptedException {
        Thread1 runnable = new Thread1();
        Thread rt = new Thread(runnable);
        rt.start();

		Threads t1 = new Threads();
        Threads t2 = new Threads();
        Threads t3 = new Threads();
        
        System.out.println("State Before running (t1) ="+t1.getState());
        t1.start();
        t1.join();//t2,t3 will start once t1 will complete
        System.out.println("State After running (t1) ="+t1.getState());
        
        t2.setDaemon(true);//backend support thread
        t2.start();
        t3.start();
        t2.interrupt();//interrupt t2 running thread
        
        Runtime r=Runtime.getRuntime();
        r.addShutdownHook(new ShutdownHook());//this will auto call before JVM exit
    }

   
}
