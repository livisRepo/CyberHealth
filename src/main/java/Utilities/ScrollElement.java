package Utilities;

import io.appium.java_client.android.AndroidDriver;

public class ScrollElement {
	public void scrollToText(String str, AndroidDriver driver){
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
	                    + str + "\").instance(0))");
	}
}
