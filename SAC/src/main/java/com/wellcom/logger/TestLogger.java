package com.wellcom.logger;

import java.io.IOException;
import java.util.logging.*;

public class TestLogger {

	/**
	 * @param args
	 */
	
	static private String encodePassword(String password) {
		String retVal="";
		char c;
		int num=0;

		for (int i=0;i<password.length();i++) {
		c=password.charAt(i);
		num = (int)c;
		System.out.println ("char="+c+" num="+num);
		if (i%2==0) {
		retVal = retVal+Integer.toHexString(num + 4 - i) + "";
		} else {
		retVal = retVal+Integer.toHexString(num + 112 - (((i - 1) / 2) * 6)) + "";
		}
		}
		retVal = retVal.toUpperCase();
		retVal = retVal+"A7FCAA504BA7E4FC";
		return retVal;
		} 
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String loggerName = "wellcomApp";
		String boundleName = "com.wellcom.logger.MensajesLog";
		Logger logger = Logger.getLogger(loggerName,boundleName);
		
       try{
	        //cmdLinelLogger = Logger.getLogger(loggerName);
	        
	        logger.addHandler(FactoryHandler.getFileHandler());
	        
	        logger.addHandler(FactoryHandler.getConsolHandler());
	        
	        logger.addHandler(FactoryHandler.getJDBCHandler("1211647627079"));
	        
       }catch(Exception ioExp){
    	   ioExp.printStackTrace();
       }
       
       try{
    	   int x=0/0;
       }catch(Exception ex){
    	   logger.severe(ex.getMessage());
       }
       
	}*/
	public static void main(String[] args) {
		System.out.print(TestLogger.encodePassword("hola"));
		
	}
	

}
