package com.bitguiders.bjt_01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bitguiders.util.User;

public class Main extends Static {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    
	public static void main(String... arg){
		LOGGER.info("...");
		User user = new User("Abdul","Kareem");
		LOGGER.info(user.toString());
		LOGGER.info(128>>4);
		
		int[] oldArray = { 3, 5, 7, 9};
		int[] newArray = { 2, 4, 6, 8, 9, 7, 5, 3};
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
		LOGGER.info(Math.ceil(-82.4));
		LOGGER.info(Math.pow(-6, 2));
	}
}
