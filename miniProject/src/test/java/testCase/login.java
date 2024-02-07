package testCase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.readFile;
import generic.util;
import generic.utility;

public class login extends util {

	@Test
	public static void Login() throws IOException, InterruptedException {
		System.out.println("Login");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		utility.jsClick(driver.findElement(By.xpath("//button[@name='loginBtn']")));
		Thread.sleep(1000);
		driver.findElement(By.id("Email")).sendKeys("iamajayts@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Password@123");
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Login']"))).click().build().perform();
		Thread.sleep(5000);
//		w.until(ExpectedConditions
//				.visibilityOf(driver.findElement(By.xpath("//button[@aria-label='Account settings']"))));
		driver.findElement(By.xpath("//button[@aria-label='Account settings']")).click();
		boolean isD = driver.findElement(By.xpath("//li[text()='Logout']")).isDisplayed();
		assertTrue(isD);
		System.out.println("Loged In");
	}

	@Test(dependsOnMethods = "Login")
	public void searchProduct() throws InterruptedException {
		System.out.println("Search");
		//driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Shirts");
		//Thread.sleep(5000);
	//	driver.findElement(By.id("searchBtn")).click(); // id="searchBtn"
		driver.findElement(By.xpath("//a[@id='men']")).click();
		Thread.sleep(5000);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'featuredProducts_cardBody')]"))));
		driver.findElement(By.xpath("//div[contains(@class,'featuredProducts_cardBody')]")).click();
		Thread.sleep(3000);
		w.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//span[text()='add to cart']"))));
		driver.findElement(By.xpath("//span[text()='add to cart']")).click();
		
		//Thread.sleep(3000);
		w.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//span[text()='add to cart']"))));
		driver.findElement(By.xpath("//button[text()='added']"));
	}

}
