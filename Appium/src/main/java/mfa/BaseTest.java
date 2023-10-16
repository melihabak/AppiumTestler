package mfa;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v108.input.model.MouseButton;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.interactions.PointerInput;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Arrays;

public class BaseTest {
	
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
			
			//options.setApp("C:\\Users\\melih.abak\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
			//options.setApp("C:\\Users\\melih.abak\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk");
			options.setApp("C:\\Users\\melih.abak\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\app-release.apk");
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	public void pinchCloseGesture(WebElement elem)
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) elem).getId(),
			    "percent", 0.75
			));
		
	}
	
	
	public void longPressAction(WebElement ele)
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
						"duration",2000));
		
	}
	
	public void flingAction(WebElement ele)
	{
		
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "direction", "up",
			    "speed", 500
			));
		
	}
	
	public void scrollToEndAction()
	{
		
		boolean canScrollMore;
		do
		{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
		}while(canScrollMore);
	}
	
	
	
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "up",
			    "percent", 0.75
			));
	}
	
	public Double getFormattedAmount(String amount)
	{
		
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
	}
	
	
    public void tap(int x, int y) {
    	PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
		service.stop();
	}
}
