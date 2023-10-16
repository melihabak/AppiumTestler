package mfa;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BrowserBaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		    service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\melih.abak\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
			service.start();
			
			UiAutomator2Options options = new UiAutomator2Options();
			
			options.setDeviceName("samsung SM-M317F");
			
			//options.setDeviceName("MFA Emulator");
			//options.setChromedriverExecutable("C:\\Users\\melih.abak\\Desktop\\chromedriver_win32");//chrome driver for suitable each emulator version. Every different emulator maybe have different chrome driver version!!!
			
			options.setCapability("browserName", "Chrome");
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	
	public Double getFormattedAmount(String amount)
	{
		
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
		service.stop();
	}
}
