package mfa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class smartremote_tc2 extends BaseTest {
	
	//tuvalet sayfasında bir test
	
	@Test
	public void FillForm() throws InterruptedException
	{
		
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();//uygulama sıfırdan koşulduğundan çıkan lokasyon iznini onaylar
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();//uygulama sıfırdan koşulduğundan çıkan yakındaki cihazlar iznini onaylar
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]")).click();//tap to connect e tıklar
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));//etraftaki cihazları bulması için 10sn bekler
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Sound masking\"]")), "content-desc", "Sound masking"));//ses maskeleme butonunun olduğu sayfaya gelince durur. Bu kısımda bu örnek spesifiğinde smartpanel sayfasından bier element de seçilebilirdi çünkü ses maskeleme aslında aynı xpath ile tuvalet sayfasında da var
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")).click(); //taharet başlatma
		Thread.sleep(15000);//su akısı icin gecmesi gereken süre bu taharette 
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")).click(); //taharet sonlandırma
		Thread.sleep(10000); // kod çalıştıktan sonra uygulamanın açık kalması gereken süre
		
	}

}
