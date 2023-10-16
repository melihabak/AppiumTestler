package mfa;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidBatteryInfo.BatteryState;
import mfa.BrowserBaseTest;

public class MobileBrowserTest extends BrowserBaseTest {
	
	@Test
	public void browserTest() {
		
		
	//driver.get("http://google.com");
	//System.out.println(driver.getTitle());
	//driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
	//driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	
		
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)","");
	String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(text, "Devops");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	double batteryPercent = driver.getBatteryInfo ().getLevel(); // get battery percent level 0(%0)-1.0(%100)
	System.out.println("Telefonun Sarj Seviyesi : "+batteryPercent);
	
	//BatteryState batteryState = driver.getBatteryInfo ().getState ();
	//System.out.println(batteryState);
	
	//Boolean isKeyboardVisible = driver.isKeyboardShown ();
	//System.out.println(isKeyboardVisible);
	
	//driver.openNotifications ();
	
	//driver.toggleLocationServices();
	
	//driver.toggleData ();
	
	//driver.toggleWifi();
	
	//driver.toggleAirplaneMode();
	
	//driver.lockDevice ();
	
	//Boolean isLocked = driver.isDeviceLocked ();
	//System.out.println(isLocked);
	
	//driver.unlockDevice ();
	
	//boolean isInstalled = this.driver.isAppInstalled ("General-Store.apk");
	//System.out.println(isInstalled);
	
	
	

		
	}
}

