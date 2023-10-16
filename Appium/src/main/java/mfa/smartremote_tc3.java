package mfa;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v108.input.model.MouseButton;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class smartremote_tc3 extends BaseTest {
	
	//tuvalet sayfasında bir test
	
	@Test
	public void FillForm() throws InterruptedException
	{
		
		
		//smarttoilet sayfasındaki kişiselleştirilebilen ayarların yapılması
		
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();//uygulama sıfırdan koşulduğundan çıkan lokasyon iznini onaylar
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();//uygulama sıfırdan koşulduğundan çıkan yakındaki cihazlar iznini onaylar
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]")).click();//tap to connect e tıklar
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));//etraftaki cihazları bulması için 10sn bekler
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Sound masking\"]")), "content-desc", "Sound masking"));//ses maskeleme butonunun olduğu sayfaya gelince durur. Bu kısımda bu örnek spesifiğinde smartpanel sayfasından bier element de seçilebilirdi çünkü ses maskeleme aslında aynı xpath ile tuvalet sayfasında da var
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[3]")).click();//Hamburger menu ikonuna tıklandı
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")).click();//erkek ikonuna tıklandı
		
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[4]")).click();//nozzle position butonuna tıklandı
		//WebElement seekBar = driver.findElement(By.className("android.widget.SeekBar"));
		//seekbar.sendKeys("100");
		//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Save\"]")).click();
		//driver.findElement(By.xpath("//android.widget.SeekBar[@content-desc=\"80%\"]")).click();
		
		
		//Dimension size = driver.manage().window().getSize();
		//System.out.print(size);
		//Thread.sleep(1000);
		
		//WebElement seekBar =  driver.findElement(By.className("android.widget.SeekBar"));
		//seekBar.sendKeys("0.8");
			
		Thread.sleep(3000);
		tap(916,1027);//5.seviyeye ayarlandı tap fonksiyonu ile
		Thread.sleep(3000);
			
		//driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")).click();
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[5]")).click();//water pressure butonuna tıklandı
		//WebElement seekbar2 = driver.findElement(By.id("android.widget.SeekBar"));
		//seekbar.sendKeys("80");
		//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Save\"]")).click();
		Thread.sleep(3000);
		tap(916,1027);//5.seviyeye ayarlandı tap fonksiyonu ile
		Thread.sleep(3000);

						
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[6]")).click();//water temperature butonuna tıklandı
		//WebElement seekbar3 = driver.findElement(By.id("android.widget.SeekBar"));
		//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Save\"]")).click();
		//Thread.sleep(1000);
		//seekBar.sendKeys();
		Thread.sleep(3000);
		tap(916,1027);//5.seviyeye ayarlandı tap fonksiyonu ile
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[7]")).click();//seat temperature butonuna tıklandı
		//WebElement seekbar4 = driver.findElement(By.id("android.widget.SeekBar"));
		Thread.sleep(3000);
		//seekbar.sendKeys("40");
		//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Save\"]")).click();
		tap(916,1027);//5.seviyeye ayarlandı tap fonksiyonu ile
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[8]")).click();//dryer temperature butonuna tıklandı
		//WebElement seekbar5 = driver.findElement(By.id("android.widget.SeekBar"));
		//Thread.sleep(1000);
		//seekbar.sendKeys("20");
		Thread.sleep(3000);
		tap(916,1027);//5.seviyeye ayarlandı tap fonksiyonu ile
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Save\"]")).click();//save butonuna tıklandı
		Thread.sleep(10000);
		
		//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")).click();
		//Thread.sleep(15000);//su akısı icin gecmesi gereken süre bu taharette
		//driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")).click();
		//Thread.sleep(10000);
		
		
	}

}







