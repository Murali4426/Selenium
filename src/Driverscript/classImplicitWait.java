package Driverscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class classImplicitWait {

	public static void main(String[] args) {

		//Variable declaration
				String URL="http://demo.guru99.com/test/web-table-element.php";		
				String pageSource1=null;
				String title=null;
				String max;
			    double m=0,r=0;
				
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
		        driver.manage().deleteAllCookies();
		        
		        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		        
		        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); 

	}

}
