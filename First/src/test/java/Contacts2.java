
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Contacts2 extends ExcelRead {

	private static AndroidDriver driver;
	private static final String FILE_NAME = "D://VeraAutomation//Test Data.xlsx";
	private static String str = null;

	public static void main(String[] args) throws Exception {

		// ExcelRead rc=new ExcelRead();
		// String vOutput=rc.ReadCellData(0, 0);
		// System.out.println(vOutput);

		FileInputStream fi = new FileInputStream("D://VeraAutomation//Test Data.xlsx");

		Workbook wb = new XSSFWorkbook(fi);
		Sheet sh = wb.getSheet("Sheet0");
		int starRow = sh.getFirstRowNum();
		int endRow = sh.getLastRowNum();

		String Input = null;
		String Key = null;

		for (int i = starRow + 1; i < endRow; i++) {

			Cell c = wb.getSheetAt(0).getRow(i).getCell(1);
			Input = c.toString();

			Cell c2 = wb.getSheetAt(0).getRow(i).getCell(2);
			Key = c2.toString();

			/*
			 * try {
			 * 
			 * 
			 * 
			 * FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			 * Workbook workbook = new XSSFWorkbook(excelFile); Sheet datatypeSheet =
			 * workbook.getSheetAt(0); Iterator<Row> iterator = datatypeSheet.iterator();
			 * 
			 * while (iterator.hasNext()) {
			 * 
			 * Row currentRow = iterator.next(); Iterator<Cell> cellIterator =
			 * currentRow.iterator();
			 * 
			 * while (cellIterator.hasNext()) {
			 * 
			 * Cell currentCell = cellIterator.next(); // int str=(int)
			 * currentCell.getNumericCellValue(); //getCellTypeEnum shown as deprecated for
			 * version 3.15 //getCellTypeEnum ill be renamed to getCellType starting from
			 * version 4.0 if (currentCell.getCellType() == CellType.STRING) { //
			 * System.out.print(currentCell.getStringCellValue() + "--"); String
			 * str=currentCell.getStringCellValue(); System.out.println(str); } else if
			 * (currentCell.getCellType() == CellType.NUMERIC) { //
			 * System.out.print(currentCell.getNumericCellValue() + "--"); int str1=(int)
			 * currentCell.getNumericCellValue(); System.out.println(str1); }
			 * 
			 * } System.out.println();
			 * 
			 * } } catch (FileNotFoundException e) { e.printStackTrace(); } catch
			 * (IOException e) { e.printStackTrace(); }
			 */

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("automationName", "uiAutomator2");
			capabilities.setCapability("deviceName", "emulator-5554");
			capabilities.setCapability("platformVersion", "6.0");
			capabilities.setCapability("platformName", "Android");
			// capabilities.setCapability("app", app.getAbsolutePath());
			// capabilities.setCapability("appPackage", "com.android.settings");
			// capabilities.setCapability("appActivity", "com.android.settings.Settings");
			capabilities.setCapability("app", "D:\\AndroidSDK\\platform-tools\\app-vportal-staging.apk");
			capabilities.setCapability("appPackage", "com.vsoft.vera.vportal");
			capabilities.setCapability("appActivity", "com.vsoft.vera.ui.LoginScreen");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			Thread.sleep(10000);

			// driver.findElementByAndroidUIAutomator("new UiScrollable(new
			// UiSelector()).scrollIntoView("+ "new UiSelector().text(\"_System_\"));");
			driver.findElement(By.id("com.vsoft.vera.vportal:id/login_screen_username_edit_text")).sendKeys("Vera");
			driver.findElement(By.id("login_screen_password_edit_text")).sendKeys("Welcome@123");
			driver.findElement(By.id("com.vsoft.vera.vportal:id/login_screen_login_text_view")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='VERA-2.1']")).isDisplayed();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//android.widget.RelativeLayout[5]")).click();

			driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
			driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='Chat with VERA']")).isDisplayed();
			driver.findElement(By.id("com.vsoft.vera.vportal:id/message_input")).sendKeys(Input);
			driver.findElement(By.id("com.vsoft.vera.vportal:id/send_button")).click();
			Thread.sleep(5000);
			String mee = driver.findElement(By.xpath("//*[contains(@text, \"balance\")]")).getText();
			System.out.println(mee);
		}
		driver.quit();
	}

}

/*
 * DesiredCapabilities capabilities = new DesiredCapabilities();
 * capabilities.setCapability("automationName", "uiAutomator2");
 * capabilities.setCapability("deviceName", "emulator-5554");
 * capabilities.setCapability("platformVersion", "6.0");
 * capabilities.setCapability("platformName", "Android");
 * //capabilities.setCapability("app", app.getAbsolutePath());
 * //capabilities.setCapability("appPackage", "com.android.settings");
 * //capabilities.setCapability("appActivity", "com.android.settings.Settings");
 * capabilities.setCapability("app",
 * "D:\\AndroidSDK\\platform-tools\\app-vportal-staging.apk");
 * capabilities.setCapability("appPackage", "com.vsoft.vera.vportal");
 * capabilities.setCapability("appActivity", "com.vsoft.vera.ui.LoginScreen");
 * driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
 * capabilities); driver.manage().timeouts().implicitlyWait(80,
 * TimeUnit.SECONDS); Thread.sleep(10000);
 * 
 * //driver.
 * findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
 * + "new UiSelector().text(\"_System_\"));"); driver.findElement(By.id(
 * "com.vsoft.vera.vportal:id/login_screen_username_edit_text")).sendKeys("Vera"
 * ); driver.findElement(By.id("login_screen_password_edit_text")).sendKeys(
 * "Welcome@123"); driver.findElement(By.id(
 * "com.vsoft.vera.vportal:id/login_screen_login_text_view")).click();
 * driver.findElement(By.xpath("//android.widget.TextView[@text='VERA-2.1']")).
 * isDisplayed(); Thread.sleep(5000);
 * driver.findElement(By.xpath("//android.widget.RelativeLayout[5]")).click();
 * 
 * driver.findElement(By.id(
 * "com.android.packageinstaller:id/permission_allow_button")).click();
 * driver.findElement(By.id(
 * "com.android.packageinstaller:id/permission_allow_button")).click();
 * driver.findElement(By.
 * xpath("//android.widget.TextView[@text='Chat with VERA']")).isDisplayed();
 * driver.findElement(By.id("com.vsoft.vera.vportal:id/message_input")).sendKeys
 * ("Hi");
 * driver.findElement(By.id("com.vsoft.vera.vportal:id/send_button")).click();
 */

/*
 * 
 * File src = new File("D:\\VeraAutomation\\Test Data.xlsx"); try {
 * FileInputStream fis = new FileInputStream(src);
 * 
 * XSSFWorkbook wb = new XSSFWorkbook(fis);
 * 
 * XSSFSheet sheet1 = wb.getSheetAt(0);
 * 
 * int rowcount = sheet1.getLastRowNum();
 * 
 * for(int i=1;i<=rowcount;i++) {
 * 
 * 
 * 
 * String str = sheet1.getRow(i).getCell(2).getStringCellValue();
 * System.out.println(str);
 * 
 * String str1 = sheet1.getRow(i).getCell(1).getStringCellValue();
 * System.out.println(str1); } } catch(Exception e) {
 * System.out.println("File not found"); }
 * 
 * 
 */

// driver.findElement(MobileBy.AndroidUIAutomator(
// "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new
// UiSelector().text('System'))"));
/*
 * driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
 * driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
 * driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
 * driver.findElement(By.id("com.android.calculator2:id/eq")).click();
 * System.out.println(driver.findElement(By.id(
 * "com.android.calculator2:id/formula")).getText());
 */
// driver.quit();
