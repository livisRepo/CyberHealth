package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class AppiumStartStop {

	// Set path of node.exe
	String nodePath = "C:/Progra~2/Appium/node.exe";
	// Set path of Appium.js
	String appiumPath = "C:/Progra~2/Appium/node_modules/appium/bin/appium.js";

	// Method for start appium server
	public void startAppium() throws ExecuteException, IOException {
		// create object for apache command line class. It will start command
		// prompt in background
		CommandLine command = new CommandLine("cmd");
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
		// Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(new Date());
		String destDir="logFile";
		String destFile="appiumLogs_"+reportDate+".txt";
		new File(destDir).mkdirs();
		// Add different arguments in command line which requires to start
		// appium server
		command.addArgument("/c");
		command.addArgument(nodePath);
		command.addArgument(appiumPath);
		// set server address
		command.addArgument("--address");
		command.addArgument("127.0.0.1");
		// set port
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--no-reset");
		// command.addArgument("--log-level");
		// command.addArgument("error");

		command.addArgument("--log");
		// set path to store appium server log file
		command.addArgument(System.getProperty("user.dir")+"/"+destDir+"/"+destFile);
		// Execute command line arguments to start appium server
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
		System.out.println("While start Appium");
	}

	// Method for stop appium server
	public void stopAppium() throws ExecuteException, IOException {
		// Add different arguments in command line which requires to stop appium
		// server
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");

		// Execute command line arguments to stop appium server
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
	}
}
