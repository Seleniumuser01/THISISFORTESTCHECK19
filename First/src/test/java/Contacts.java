
import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

	public class Contacts 
	{

		private static AndroidDriver driver;
		public static void main(String[] args) throws MalformedURLException, InterruptedException {

		

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("automationName", "uiAutomator2");
			capabilities.setCapability("deviceName", "emulator-5554");
			capabilities.setCapability("platformVersion", "6.0");
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "com.android.settings");
			capabilities.setCapability("appActivity", "com.android.settings.Settings");

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			Thread.sleep(10000);		
			 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"_System_\"));");
			
		//	driver.findElement(MobileBy.AndroidUIAutomator(
		          //   "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text('System'))"));
			/*driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
			driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
			driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
			driver.findElement(By.id("com.android.calculator2:id/eq")).click();
			System.out.println(driver.findElement(By.id("com.android.calculator2:id/formula")).getText());		*/
			driver.quit();
			
			

	}


	}

	

