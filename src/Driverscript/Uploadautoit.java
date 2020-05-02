package Driverscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Uploadautoit {
	
	public static void main(String[] args) throws IOException {
		String URL="https://www.zamzar.com/";		
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
        
     // Wait For Page To Load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Go to URL
        driver.get(URL);

        // Maximize Window
        driver.manage().window().maximize();
        
        WebDriverWait wait = new WebDriverWait(driver, timeout);
      
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadfile")));
//        WebElement browse =driver.findElement(By.id("uploadfile"));
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-default btn-lg'])")));
        WebElement browse =driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'])"));
        
      //Creating the JavascriptExecutor interface object by Type casting		
        JavascriptExecutor js = (JavascriptExecutor)driver;	
        js.executeScript("arguments[0].click();", browse);
		 //To click on the 'browse' button
		 //browse.click();
		 
		 //To call the AutoIt script
		 Runtime.getRuntime().exec(System.getProperty("user.dir")+"/files/Uploadfile1.exe");
		 
		 String uploadfile=browse.getText();
		 
		 System.out.println("uploadfile-->"+uploadfile);
		 
		 //'close' method is used to close the browser window
		 driver.close();

	}

}
