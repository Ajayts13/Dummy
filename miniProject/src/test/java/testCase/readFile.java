package testCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.util;

public class readFile extends util {
	
@Test(dependsOnMethods = "login")
	public void searchProduct() {

		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Shirts");
		driver.findElement(By.id("searchBtn")).click(); // id="searchBtn"
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		w.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'featuredProducts_cardBody')]"))));

	}

}
