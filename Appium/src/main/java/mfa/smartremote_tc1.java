package mfa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class smartremote_tc1 extends BaseTest {
	
	//panel sayfasında bir test
	
	@Test
	public void FillForm() throws InterruptedException
	{		
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();//uygulama sıfırdan koşulduğundan çıkan lokasyon iznini onaylar
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();//uygulama sıfırdan koşulduğundan çıkan yakındaki cihazlar iznini onaylar
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]")).click();//tap to connect e tıklar
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));//etraftaki cihazları bulması için 10sn bekler
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Sound masking\"]")), "content-desc", "Sound masking"));//ses maskeleme butonunun olduğu sayfaya gelince durur. Bu kısımda bu örnek spesifiğinde smartpanel sayfasından bier element de seçilebilirdi çünkü ses maskeleme aslında aynı xpath ile tuvalet sayfasında da var
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]")).click();//half flush butonuna basıldı
		//driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Sound masking\"]")).click(); //Bu esnada ses maskeleme butonuna da basıldı
		Thread.sleep(4000);
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));// uygulamada androidin kendi geri tusu özelliği kapalı oldugundan calısmamalı
		//Thread.sleep(3000);
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));//Bu kısımda uygulamadan cıkmıs ana sayfaya donmus oldugundan calısmalı.android telefonun ııı tuşuna basıldı
		Thread.sleep(3000);
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));//Bu kısımda uygulamadan cıkmıs ana sayfaya donmus oldugundan calısmalı
		//Thread.sleep(3000);
		double batteryPercent = driver.getBatteryInfo ().getLevel(); // get battery percent level 0(%0)-1.0(%100)
		System.out.println("Telefonun Sarj Seviyesi : "+batteryPercent*100);
		//driver.findElement(AppiumBy.id("com.sec.android.app.launcher:id/clear_all_button")).click(); //sekmedeki uygulamaların hepsini kapatır
		WebElement ele = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"vitra_smart_remote\"]/android.view.View[1]"));//ele objesi oluşturuldu ve ııı butonuna basıldıktan sonra uygulama ekranı bu objeye tanımlandı
		swipeAction(ele,"up");//uygulama yukarı fırlatılarak kapatıldı
		Thread.sleep(4000);
		driver.lockDevice();//telefon kilit moduna alındı	
		//WebElement elem = driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/com.android.launcher3.PagedView/android.view.ViewGroup/android.view.ViewGroup"));
		//pinchCloseGesture(elem);
		//driver.unlockDevice();
		//Thread.sleep(8000);			
	}
}
