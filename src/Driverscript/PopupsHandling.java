package Driverscript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupsHandling {

	public static void main(String[] args) throws InterruptedException {
		String URL="C:/Training/Samplealert.html";		
		String pageSource1=null;
		String title=null;
		int timeout=30;
		WebElement txt_Searchfield=null;
		WebDriverWait wait;
		Alert alert;
		
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
        
        Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='alertFunction()']")).click();
		Thread.sleep(2000);
		alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		
		Thread.sleep(2000);
		
		driver.get("C:/Training/confirmation.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='confirmFunction()']")).click();
		Thread.sleep(2000);
		alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		
		Thread.sleep(2000);
		
		driver.get("C:/Training/prompt.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='promptFunction()']")).click();
		Thread.sleep(2000);
		alert=driver.switchTo().alert();
		driver.switchTo().alert().sendKeys("Helllo");
		System.out.println(alert.getText());
		alert.accept();
		
		driver.close();

	}

}
