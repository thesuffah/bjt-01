package com.bitguiders.bjt_01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import static ClassName.*;
public class Static {
	private static final Logger LOGGER = LogManager.getLogger(Static.class);
	   int a=5;
	static{
		LOGGER.debug("Static block: Who called me..?");
	}
	{
		LOGGER.info("Non Static block: Who called me..?");
	}
	public static synchronized void main(String... arg) {
		
		new Static();
		test();
	}
	static public void test(){
		LOGGER.info("static public void order changed");
	}
   
}
