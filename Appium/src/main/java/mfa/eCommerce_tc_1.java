package mfa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest {
	
	@Test
	public void FillForm() throws InterruptedException
	{
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("melih abak");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cuba\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Cuba']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(5000);
	}

}
