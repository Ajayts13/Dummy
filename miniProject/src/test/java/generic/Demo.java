package generic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Demo  {
	static WebDriver driver=null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
			try {
				driver = new ChromeDriver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

}
