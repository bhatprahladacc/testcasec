package Bpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UtilityClass {

	static WebDriver driver;
	
	public static WebDriver browserbegin(String bname, String url) {
		
		if(bname.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.05.01\\Downloads\\Test\\Sel\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		return driver;
	}
	
}
