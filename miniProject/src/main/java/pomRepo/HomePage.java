package pomRepo;

import java.security.PrivateKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver Driver;
	
	@FindBy(xpath ="//button[@name='loginBtn']") WebElement loginlink;
	@FindBy(id="Email") WebElement emailTextfield;
	@FindBy(id="Password") WebElement PasswordTextfield;
	

}
