package Utilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Initiate {
	public AndroidDriver driver;
	 Dimension size;

	 public void setUp() throws Exception {
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("deviceName", "Android Emulator");
	  capabilities.setCapability("browserName", "Android");
	  capabilities.setCapability(CapabilityType.VERSION, "6.0");
	  capabilities.setCapability("platformName", "Android");
	  capabilities.setCapability("appPackage","com.deemsysinc.cyberhealthapp");
	  capabilities.setCapability("appActivity","com.deemsysinc.cyberhealthapp.authentication.MainActivity");
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	 }

}
