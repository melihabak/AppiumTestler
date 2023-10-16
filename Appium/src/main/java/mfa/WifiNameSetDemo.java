package mfa;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class WifiNameSetDemo extends BaseTest{
	
	@Test
	public void WifiNameSettings() throws MalformedURLException
	{
		//code to start server
		//AnroidDriver,iOSDriver
		//Appium Code -> Appium Server -> Mobile
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		 
		driver.findElement(By.id("android:id/edit")).sendKeys("mfa_wifi");
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		
		//set wifi name
			
	}
}
