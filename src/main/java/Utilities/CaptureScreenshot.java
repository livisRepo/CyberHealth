package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class CaptureScreenshot {
	public String destDir;
	DateFormat dateFormat;
	
	public void takeScreenshot(String str, AndroidDriver driver) throws IOException{
		//set folder name to store screenshots
		destDir="Screenshots/"+str;
		
		//capture screenshot
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//set date format to set it as screenshot file name
		dateFormat=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ssaa");
		
		//create folder under project with the name "screenshots"
		new File(destDir).mkdirs();
		
		//set file name using current date and time
		String destFile=dateFormat.format(new Date())+".png";
		
		FileUtils.copyFile(scrFile, new File(destDir+"/"+destFile));
	}
}
