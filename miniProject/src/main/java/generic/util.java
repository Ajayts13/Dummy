package generic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class util {
	public static WebDriver driver;

	// Annotation
	@BeforeClass

	public void launchBrowser() throws IOException {

		// File Read
		Properties pro = new Properties();
		FileReader fr = new FileReader("./src/test/resources/testData.properties");
		pro.load(fr);
		String Browsername = pro.getProperty("browserName").toLowerCase();

		System.out.println(Browsername);
		switch (Browsername) {
		// chrome Browser
		case "chrome": {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\User\\AppData\\Roaming\\fire-flink-client\\localnode\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
		// firefox Browser
		case "firefox": {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\User\\AppData\\Roaming\\fire-flink-client\\localnode\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		}
		// edge Browser
		case "edge": {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		}
		// safari Browser
		case "safari": {
			driver = new SafariDriver();
			driver.manage().window().maximize();
			break;
		}
		}

	}

	@BeforeMethod

	public void navigateToApp() throws IOException {

		String u = readFile.fileread("Url");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(u);

	}

//	@AfterClass
//	public void tearDown() {
//		driver.close();
//	}

}
