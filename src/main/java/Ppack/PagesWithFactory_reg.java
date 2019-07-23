package Ppack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PagesWithFactory_reg {
	WebDriver driver;

	public PagesWithFactory_reg(WebDriver driver) {
		this.driver = driver;
	} 
	
	@FindBy(name = "userName")
	@CacheLookup
	WebElement username;
	
	@FindBy(name = "firstName")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(name = "lastName")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name = "confirmPassword")
	@CacheLookup
	WebElement confirmpassword;
	
	@FindBy(xpath = "//input[@value='Male']")
	@CacheLookup
	WebElement gender;
	
	@FindBy(id = "emailAddress")
	@CacheLookup
	WebElement email;
	
	@FindBy(name = "mobileNumber")
	@CacheLookup
	WebElement mobilenumber;
	
	@FindBy(name = "dob")
	@CacheLookup
	WebElement dateob;
	
	@FindBy(id = "address")
	@CacheLookup
	WebElement address;
	
	@FindBy(name = "securityQuestion")
	@CacheLookup
	Select secq;
	
	@FindBy(name = "answer")
	@CacheLookup
	WebElement answer;
	
	@FindBy(name = "Submit")
	@CacheLookup
	WebElement register;
	
	public void regi(String usn, String psw, String fname, String lname, String cpsw, String phno, String eid,String add,String daob, String ans) {
		username.sendKeys(usn);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		password.sendKeys(psw);
		confirmpassword.sendKeys(cpsw);
		gender.click();
		email.sendKeys(eid);
		mobilenumber.sendKeys(phno);
		dateob.sendKeys(daob);
		address.sendKeys(add);
		Select q = new Select(driver.findElement(By.id("securityQuestion")));
		q.selectByIndex(1);
		//secq.selectByIndex(1);
		answer.sendKeys(ans);
		register.click();
	}
	
	public void login(String usn, String psw) {
		username.sendKeys(usn);
		password.sendKeys(psw);
	}
}
