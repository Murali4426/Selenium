package Driverscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UploadFileTest {

	public static void main(String[] args) throws InterruptedException {
		String URL="C:/Training/fileupload.html";		
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
        
        WebElement upload = driver.findElement(By.id("uploadfile"));
        Thread.sleep(10000);
        System.out.println("File upload path:"+System.getProperty("user.dir")+"/files/ApachePOI.docx");
        upload.sendKeys(System.getProperty("user.dir")+"/files/ApachePOI.docx");
        Thread.sleep(10000);
        driver.findElement(By.id("submit")).click();
        
      //'close' method is used to close the browser window
      		driver.close();

	}

}
