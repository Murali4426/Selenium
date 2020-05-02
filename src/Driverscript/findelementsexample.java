package Driverscript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class findelementsexample {
	
	
	public static void main(String[] args) throws MalformedURLException, Exception {
		// TODO Auto-generated method stub
		
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
        //driver.navigate().to("http://www.amazon.com");
        driver.manage().window().maximize();
        
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println("Number of elements:" +elements.size());

        
//        for (int i=0; i<elements.size();i++){
//            System.out.println("Link Name:" + elements.get(i).getAttribute("href"));
//
//          }
        
        //Enter a value in Serach field
        WebElement txt_Searchfield=driver.findElement(By.id("twotabsearchtextbox"));
        //txt_Searchfield.clear();
        //if(txt_Searchfield.isDisplayed())
        if((txt_Searchfield.isEnabled())&& (txt_Searchfield.isDisplayed())) 	
        {
        	System.out.println("Object  isEnabled");
	        txt_Searchfield.click();        
	        txt_Searchfield.sendKeys("Amazon Devices");
        }
        

         Thread.sleep(600);
         
         txt_Searchfield.sendKeys(Keys.CONTROL+"a");
         txt_Searchfield.sendKeys(Keys.DELETE);
         Thread.sleep(6000);
         txt_Searchfield.click();
         txt_Searchfield.sendKeys("Amazon Devices");
        
         
        Thread.sleep(600);
        //txt_Searchfield.sendKeys(Keys.BACK_SPACE);
       
        //Driver QUIT and close
        driver.quit();
        
         
         
        
	}     
	
	
}
