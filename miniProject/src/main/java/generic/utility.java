package generic;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class utility extends util {

//	public static final String ScreeenShotFolderPath = null;
	public final String ScreeenShotFolderPath = "C:\\Users\\User\\Desktop\\FireFlink Doc\\Selenium Work Space\\SELENIUM\\miniProject\\src\\test\\resources\\ScreenShots\\";
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));

	public static void setTimes() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	// JavaScriptClick
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	// JavaScript Scroll_to_Element
	public static void jsScrolltoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("window.scrollBy(0,-150)");

	}

	// Action Class Mouse Move
	public static void mouseMove(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform(); // wait till element visible,clickable
	}

	// Action Class Right Click
	public static void rightClick() {
		Actions action = new Actions(driver);
		action.contextClick().build().perform();

	}

	// Action scrolltoElement
	public static void scrolltoElement(WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).build().perform();

	}

	// Enter Input
	public static void EnterInput(WebElement element, String input) {
		element.sendKeys(input);
	}

	// File Read

	public static String fileread(String key) throws IOException {
		String url = "";
		Properties read = new Properties();
		FileReader fr = new FileReader("./src/test/resources/testData.properties");
		read.load(fr);
		url = read.getProperty(key);
		return url;

	}

	// get Screenshot
	public static void getScreenShot(String filenameAndFormate) throws IOException {

		String ScreenshotSubFolderName = null;
		if (ScreenshotSubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss");
			ScreenshotSubFolderName = myDateObj.format(myFormat);
		}
		utility u = new utility();
		String s = u.ScreeenShotFolderPath + ScreenshotSubFolderName;
		// create sub folder
		File subfolder = new File(s);
		subfolder.exists();

		// capture ScreenShot
		String newSS = s + "\\" + filenameAndFormate;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		// File ss = new File(newSS);
		FileUtils.copyFile(src, new File(newSS));
		if (new File(newSS).exists()) {
			System.out.println("ScreenShot is catpured successfully");

		} else {
			System.out.println("Failed to Capture ScreenShots");
		}

	}

}
