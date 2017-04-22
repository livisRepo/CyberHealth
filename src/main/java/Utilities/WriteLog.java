package Utilities;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.logging.Log;
import org.openqa.selenium.logging.LogEntry;

import io.appium.java_client.android.AndroidDriver;

public class WriteLog {
	public void captureLog(AndroidDriver driver)
		    throws Exception {
		    DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
		    //Date today = Calendar.getInstance().getTime();
		    String reportDate = df.format(new Date());
		    String logPath = System.getProperty("user.dir")+"\\logFile\\";
		   // log.info(driver.getSessionId() + ": Saving device log...");
		    List<LogEntry> logEntries = driver.manage().logs().get("logcat").filter(Level.ALL);
		    File logFile = new File(logPath + reportDate + "_appiumLogs.txt");
		    PrintWriter log_file_writer = new PrintWriter(logFile);
		    for(LogEntry temp:logEntries){
		    	log_file_writer.println(temp );
		    }
		    
		    log_file_writer.flush();
		    //log.info(driver.getSessionId() + ": Saving device log - Done.");
		}
}
