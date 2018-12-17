package chapter7;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest{
	public static void main(String[] args){
		/*Logger.getGlobal().info("File->Open menu item selectes");
		Logger.getGlobal().setLevel(Level.OFF);
		Logger.getGlobal().info("File->Open menu item selectes");
		Logger.getGlobal().setLevel(Level.ALL);
		Logger.getGlobal().info("File->Open menu item selectes");*/
		
/*	 Logger myLogger = Logger.getLogger("com.mycompany.myapp");
		myLogger.setLevel(Level.FINE);
		
		String message = "sss";
		myLogger.fine(message);*/
		
/*		Logger logger = Logger.getLogger("com.mycompany.myapp2");
		logger.setLevel(Level.FINE);q
		logger.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);
		logger.info("sssss");*/
		
		Logger logger = Logger.getLogger("myapp3", "chapter7/logmessages");
		logger.info("readingFile");
	}
}