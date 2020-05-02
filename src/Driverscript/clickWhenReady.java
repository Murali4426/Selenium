package Driverscript;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class clickWhenReady {

	public static void main(String[] args) {
		//Variable declaration
				String URL="http://www.amazon.com";		
				String pageSource1=null;
				String title=null;
				int timeout=1;
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
		        WebDriverWait wait = new WebDriverWait(driver, timeout);
		        txt_Searchfield=wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		        txt_Searchfield.sendKeys("Amazon Devices");
		        
		        
	}

}
