package Tpack;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Bpack.UtilityClass;
import Ppack.PagesWithFactory_reg;
import Ppack.PagesWithFactory_regpage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterWithFactory {
	
	WebDriver driver;
	
	@Given("^The user is at the Registration page of TestMeApp$")
	public void the_user_is_at_the_Registration_page_of_TestMeApp() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Given");
	    
	    driver = UtilityClass.browserbegin("chrome", "http://10.232.237.143:443/TestMeApp");
	    PagesWithFactory_regpage reg = PageFactory.initElements(driver, PagesWithFactory_regpage.class);
	    reg.regpage();
	    WebDriverWait wait = new WebDriverWait(driver, 50);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("userName")));
	    Assert.assertEquals(driver.getTitle(), "Sign Up");
	    System.out.println("At Registration Page");
	    
	}

	@When("^The user aheres to valid credentials which are$")
	public void the_user_aheres_to_valid_credentials_which_are(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("When");
		PagesWithFactory_reg rege = PageFactory.initElements(driver, PagesWithFactory_reg.class);
		List<Map<String,String>> credentials = arg1.asMaps(String.class, String.class);
		for(int i=0;i<credentials.size();i++) {
		rege.regi(credentials.get(i).get("username"), credentials.get(i).get("password"), credentials.get(i).get("firstname"), credentials.get(i).get("lastname"), credentials.get(i).get("cpassword"), credentials.get(i).get("number"), credentials.get(i).get("emid"), credentials.get(i).get("addr"), credentials.get(i).get("dtob"), credentials.get(i).get("ansr"));
		}
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Login")));
		/*
		for(int i=0;i<credentials.size();i++) {
			rege.login(credentials.get(i).get("username"), credentials.get(i).get("password"));
			}
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("SignIn")));
		*/
		
	}

	@Then("^The user is redirected to login page with success intimation$")
	public void the_user_is_redirected_to_login_page_with_success_intimation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Then");
		Assert.assertEquals(driver.getTitle(), "Login");
		System.out.println("Registration Successful");
		driver.close();
	}
	
	@Given("^The User is at Login page$")
	public void the_User_is_at_Login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = UtilityClass.browserbegin("chrome", "http://10.232.237.143:443/TestMeApp");
		
		driver.findElement(By.partialLinkText("SignIn")).click();
		
		
	}

	@When("^The user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_enters_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.name("userName")).sendKeys(arg1);
		driver.findElement(By.name("password")).sendKeys(arg2);
		
		driver.findElement(By.name("Login")).click();
		
	}

	@Then("^The user is redirected to home page$")
	public void the_user_is_redirected_to_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.getTitle(), "Home");
		System.out.println("Login Successful");
		driver.close();
		
	}
	
	@Given("^The User is at home page after login$")
	public void the_User_is_at_home_page_after_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
		driver = UtilityClass.browserbegin("chrome", "http://10.232.237.143:443/TestMeApp");
		
		driver.findElement(By.partialLinkText("SignIn")).click();
		
		driver.findElement(By.name("userName")).sendKeys("Lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		
		driver.findElement(By.name("Login")).click();
		
		Assert.assertEquals(driver.getTitle(), "Home");
		
		System.out.println("The User is At Home page");
	    
	}

	@When("^The user enters the product he wants \"([^\"]*)\" with suggestions$")
	public void the_user_enters_the_product_he_wants_with_suggestions(String arg1, DataTable arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		driver.findElement(By.id("myInput")).click();
		Actions act = new Actions(driver);
		
		driver.findElement(By.id("myInput")).sendKeys("Head");
		act.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().build().perform();
		
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();

	}

	@Then("^The user is redirected to the results of the search$")
	public void the_user_is_redirected_to_the_results_of_the_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(driver.findElement(By.cssSelector("body > section > div > div > div.col-sm-9 > div > div > div > div:nth-child(1) > center:nth-child(1) > h4")).getText(), "Headphone");
	    System.out.println("Element Search Successful");
	    driver.close();
	}
	
	@Given("^The user Alex is registered into TestMeApp$")
	public void the_user_Alex_is_registered_into_TestMeApp() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = UtilityClass.browserbegin("chrome", "http://10.232.237.143:443/TestMeApp");
		
		driver.findElement(By.partialLinkText("SignIn")).click();
		
		driver.findElement(By.name("userName")).sendKeys("Lalitha");
		driver.findElement(By.name("password")).sendKeys("Password123");
		
		driver.findElement(By.name("Login")).click();
		
		Assert.assertEquals(driver.getTitle(), "Home");
		
		System.out.println("Alex logs in to search");
		
		
	}

	@When("^The user Alex is at home page after login and Searches the \"([^\"]*)\" he wants like Headphone$")
	public void the_user_Alex_is_at_home_page_after_login_and_Searches_the_he_wants_like_Headphone(String arg1, DataTable arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		driver.findElement(By.id("myInput")).click();
		Actions act = new Actions(driver);
		
		driver.findElement(By.id("myInput")).sendKeys(arg1);
		act.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().build().perform();
		
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		
		System.out.println("Alex searches for his desire");
		
	}

	@When("^The user Alex tries to proceed with an empty cart$")
	public void the_user_Alex_tries_to_proceed_with_an_empty_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//if(driver.findElement(By.partialLinkText("Cart")).isDisplayed()) {
		//	Assert.fail();
		//}
		WebDriverWait wait = new WebDriverWait(driver,100000000);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText("Cart")));
	     
	}

	@Then("^The The TestMeApp does not display the cart icon$")
	public void the_The_TestMeApp_does_not_display_the_cart_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver,1000);
	   
	    if(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText("Cart")))) {
	    	System.out.println("The Cart function is unavailable for scenario and successful");
	    }
	    else
	    	Assert.fail();
		
		driver.close();
	}
	
	
 
}
