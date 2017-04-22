package CH;

import Utilities.AppiumStartStop;
import Utilities.CaptureScreenshot;
import Utilities.Initiate;
import Utilities.LatestFileFromDir;
import Utilities.ScrollElement;
import Utilities.WriteLog;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.NumberToWord;

public class Register {

	AppiumStartStop appiumStartStop = new AppiumStartStop();
	AndroidDriver driver;
	Initiate initiate = new Initiate();
	WebDriverWait wait;
	ScrollElement scrollElement = new ScrollElement();
	NumberToWord numberToWord = new NumberToWord();
	WriteLog writeLog = new WriteLog();
	CaptureScreenshot captureScreenshot = new CaptureScreenshot();
	LatestFileFromDir latestFileFromDir = new LatestFileFromDir();

	String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
	ExtentReports extentReports = new ExtentReports(extentReportFile, false);
	ExtentTest extentTest = extentReports.startTest("My first extent test", "Register New User");

	@BeforeTest
	public void setUpNew() throws Exception {
		appiumStartStop.startAppium();
		System.out.println("After start Appium");
		Thread.sleep(15000);
		initiate.setUp();
		driver = initiate.driver;
	}

	@Test
	public void registerForm() throws Exception {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String dirPath = System.getProperty("user.dir") + "\\Screenshots\\" + methodName;
		int noOfFiles = new File(dirPath).listFiles().length;
		int i = 19;
		Boolean isAlertBoxPresent;
		driver.manage().logs().get("logcat").filter(Level.ALL);
		// Click SignUp button
		driver.findElement(By.name("Signup")).click();
		extentTest.log(LogStatus.INFO, "Clicked Sign Up button");

		while (true) {
			driver.findElement(By.name("Email Address")).sendKeys("user" + i + "@gmail.com" + "\n");
			Thread.sleep(15000);
			isAlertBoxPresent = driver.findElements(By.id("com.deemsysinc.cyberhealthapp:id/alertTitle")).size() > 0;
			System.out.println(i + " : " + isAlertBoxPresent);

			if (isAlertBoxPresent) {
				driver.findElement(By.name("OK")).click();
				i = i + 1;
			} else {
				extentTest.log(LogStatus.INFO, "Entered Email Address");
				break;
			}
		}

		// Wait until complete email verification
		wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));

		// Enter FirstName
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("User" + "\n");
		extentTest.log(LogStatus.INFO, "Entered First Name");
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).clear();
		driver.hideKeyboard();
		//driver.getKeyboard().sendKeys(Keys.CLEAR);
		
		// Enter Lastname
		driver.findElement(By.xpath("//android.widget.EditText[@index='2']")).sendKeys(numberToWord.convertToWord(i) + "\n");
		extentTest.log(LogStatus.INFO, "Entered Last Name");
		// Enter Password
		driver.findElement(By.xpath("//android.widget.EditText[@index='3']")).sendKeys("User@123" + "\n");
		extentTest.log(LogStatus.INFO, "Entered Password");
		
		// Enter Confirm Password
		driver.findElement(By.xpath("//android.widget.EditText[@index='4']")).sendKeys("User@123" + "\n");
		
		// Scroll to Next button
		// scrollElement.scrollToText("Next", driver);

		//System.out.println("Number of Files before Screenshot " + new File(dirPath).listFiles().length);

		captureScreenshot.takeScreenshot(methodName, driver);

		//System.out.println("Number of Files after Screenshot " + new File(dirPath).listFiles().length);

		// Click Next buton
		driver.findElement(By.name("Next")).click();

		isAlertBoxPresent = driver.findElements(By.id("com.deemsysinc.cyberhealthapp:id/alertTitle")).size() > 0;
		if (isAlertBoxPresent) {
			new File(latestFileFromDir.getLatestFilefromDir(dirPath).getAbsolutePath()).delete();
		}
		else{
			if (new File(dirPath).listFiles().length > noOfFiles) {
				extentTest.log(LogStatus.INFO,
						extentTest.addScreenCapture(latestFileFromDir.getLatestFilefromDir(dirPath).getAbsolutePath()));
			}
		}

		/*
		 * //Select Security Question
		 * driver.findElement(By.xpath("//android.widget.TextView[@index='0']"))
		 * .click(); driver.findElement(By.name(
		 * "What was the name of your first pet?")).click();
		 * 
		 * //Enter security answer
		 * driver.findElement(By.name("answer")).sendKeys("Puppy");
		 * 
		 * //Click Register button
		 * driver.findElement(By.xpath("//android.widget.Button[@index='2']")).
		 * click();
		 */

		Thread.sleep(5000);

		// System.out.println(dirPath+" file path");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.INFO, result.getThrowable());
		}
	}

	@AfterTest
	public void end() throws Exception {
		extentReports.endTest(extentTest);
		extentReports.flush();

		// writeLog.captureLog(driver);
		driver.quit();
		appiumStartStop.stopAppium();
	}

}
