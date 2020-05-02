package Driverscript;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle_Demo {

	public static void main(String[] args) throws InterruptedException {
		String URL="http://demo.guru99.com/popup.php";		
		String pageSource1=null;
		String title=null;
		int timeout=30;
		WebElement txt_Searchfield=null;
		WebDriverWait wait;
		
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

        System.out.println("Main Window"+driver.getWindowHandle());
        
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();			
		
        
        String MainWindow=driver.getWindowHandle();	
        
        System.out.println("Main Window"+MainWindow.toString());
        		
        // To handle all new opened window.				
            Set<String> s1=driver.getWindowHandles();		
            Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
            	
            	    //System.out.println("Child Window"+driver.getWindowHandle());
            	    System.out.println("Child Window"+ChildWindow.toString());
            	    Thread.sleep(5000);
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);	                                                                                                           
                    driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");                			
                    
                    driver.findElement(By.name("btnLogin")).click();			
                                 Thread.sleep(5000);
                         // Closing the Child Window.
                        driver.close();		
                        
            }		
        }		
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(MainWindow);
            
            driver.close();	
    }
}
