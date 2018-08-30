package com.wellcom.logger;

import java.io.IOException;
import java.util.logging.*;

public class FactoryHandler {
	static public String logingLevelDefault = "ALL"; 
	static public String loggerNameDefault = "wellcomApp";
	static public String boundleNameDefault= "com.wellcom.logger.MensajesLog";
	static public String logFileDefault = "/wellcomApp.log";
	static public int limitDefault = 1000000; 
    static public int countDefault = 1;
	
		
	public Logger creaLogger(){
		return Logger.getLogger(loggerNameDefault,boundleNameDefault);
	}
	
	static public Handler  getFileHandler(String loginLevel,String logFile,int count,int limit)throws IOException {
			FileHandler fh = new FileHandler(logFile, limit, count, true);
			fh.setFormatter(new SimpleFormatter());
	        fh.setLevel(Level.parse(loginLevel));
	        return fh;
	
	}
	
	static public Handler  getFileHandler()throws IOException{
		return getFileHandler(logingLevelDefault,logFileDefault,countDefault,limitDefault);
	}
	
	static public Handler  getFileHandler(String logingLevel)throws IOException{
		return getFileHandler(logingLevel,logFileDefault,countDefault,limitDefault);
	}
	
	static public Handler  getFileHandler(String logingLevel,String logFile)throws IOException{
		return getFileHandler(logingLevel,logFile,countDefault,limitDefault);
	}
	
	static public Handler getConsolHandler(String loginLevel){
		ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new SimpleFormatter());
        ch.setLevel(Level.parse(loginLevel));
        return ch;
	}
	
	static public Handler getConsolHandler(){
		return getConsolHandler(logingLevelDefault);
	}
	
	static public Handler getJDBCHandler (String loginLevel,String usuarioId){
		JDBCHandler jdbch=new JDBCHandler(usuarioId);
		jdbch.setFormatter(new SimpleFormatter());
	    jdbch.setLevel(Level.parse(loginLevel));
	    return jdbch;
	}
    
	static public Handler getJDBCHandler (){
		return getJDBCHandler(logingLevelDefault,"");
	}
	
	static public Handler getJDBCHandler (String usuarioId){
		return getJDBCHandler(logingLevelDefault,usuarioId);
	}
	
}
