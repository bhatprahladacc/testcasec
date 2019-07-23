package Ppack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PagesWithFactory_regpage {
	
	WebDriver driver;
	
	public PagesWithFactory_regpage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(partialLinkText = "SignUp")
	@CacheLookup
	WebElement SignUp;

	
	public void regpage() {
		SignUp.click();
	}
}
