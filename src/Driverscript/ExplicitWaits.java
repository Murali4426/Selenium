package Driverscript;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits {

	public static void main(String[] args) {

		String URL="http://www.amazon.com";		
		String pageSource1=null;
		String title=null;
		int timeout=30;
		WebElement txt_Searchfield=null;
		
        //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        System.setProperty("webdriver.chromedriver.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver(options);
        
        //Navigating or launch the application
        driver.get(URL);
        //driver.navigate().to("http://www.amazon.com");
        driver.manage().window().maximize();
        
        System.out.println("Get title"+driver.getTitle());	
        
      //This waits up to 15 seconds before throwing a TimeoutException or if it finds the element will return it in 0 - 15 seconds
      	WebDriverWait wait = new WebDriverWait (driver, 5);
      	
      //Title of the webpage is "Software Testing Material - A site for Software Testers"
      	wait.until(ExpectedConditions.titleIs(driver.getTitle()));
  		//If the above condition met then the browser will be closed
  		//To close the browser
  		driver.close();
      		

	}

}
