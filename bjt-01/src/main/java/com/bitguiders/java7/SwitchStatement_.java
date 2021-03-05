package com.bitguiders.java7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SwitchStatement_ {
    private static final Logger LOGGER = LogManager.getLogger(SwitchStatement_.class);
    
	public static void main(String[] args) {

		String str = "two";
		switch(str){
		case "one":
			LOGGER.info("You fond 1");
			break;
		case "two":
			LOGGER.info("You fond 2");
			//break; all below casses will execute
		case "three":
			LOGGER.info("You fond 3");
			//break;
		default:
			LOGGER.info("default");
		}
	}

}
