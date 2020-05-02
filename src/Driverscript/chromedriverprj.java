package Driverscript;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class chromedriverprj {

	public static void main(String[] args) throws InterruptedException {
		// Path to geckodriver executable
		
        System.out.println(System.getProperty("user.dir"));
        //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        System.setProperty("webdriver.chromedriver.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.google.com");
        String title = driver.getTitle();
        Thread.sleep(30);
        System.out.println("Title is --->" + title );
        //driver.quit();
        
        
        //String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
        //driver.findElement(By.xpath("//a[contains(text(),'Amazon Devices')]")).click();
        
//        Browser(Browsername);
//        
//        if(Browsername.equal("Chrome"))
//        {
//        	 WebDriver driver = new ChromeDriver(options);
//        }else if(Browsername.equal("Firefox"))
//        {
//        	WebDriver driver = new Firefox();
//        }
//        
//        Switch(Browsername)
//         Case Chrome:
//        	 WebDriver driver = new ChromeDriver(options);
//             break;
//         Case Firefox:
//        	 WebDriver driver = new Firefox();
//             break;
//        	 

  }


}
