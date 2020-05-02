package Driverscript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeNavigateURL {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(System.getProperty("user.dir"));
		
		//Variable declaration
		String URL="http://www.amazon.com";		
		String pageSource1=null;
		String title=null;
		
        //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        System.setProperty("webdriver.chromedriver.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver(options);
        
        //Navigating or launch the application
        driver.get(URL);
        //driver.navigate().to(URL);
        driver.manage().window().maximize();
        
        //driver title
        title = driver.getTitle();
        Thread.sleep(30);
        System.out.println("Title is --->" + title );
        
        //Validating the title
        if(title.equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"))
        {
        	System.out.println("Excepted Title is --->" + title );
        }
        else
        {
        	System.out.println("Wrong Title is --->" + title );
        }
        	
        
        //Strategy to get the Page Source 
        String pageSource = driver.getPageSource();
        System.out.println("PageSource --->" + title );
        
        
        
        
        WebElement lnk_BestSellers=driver.findElement(By.xpath("//a[contains(text(),'Best Sellers')]"));
        lnk_BestSellers.click();
        
      //driver title
        title = driver.getTitle();
        Thread.sleep(30);
        System.out.println(" Best Sellers Title is --->" + title );
        
        System.out.println(" Current URL--->" + driver.getCurrentUrl() );
        
        Thread.sleep(600);
        
      //Navigate Forward and Backward:
        driver.navigate().back();
        
        Thread.sleep(600);
        
        driver.navigate().forward();
        //driver.quit();
        
        //Refresh the page
        driver.navigate().refresh();
        
        
        driver.navigate().to("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb_azl");
        String title2=driver.getTitle();
        System.out.println(" Navigated URL Title is --->" + title2 );
//        
//        //Driver QUIT and close
//        driver.quit();
        
	}

}
