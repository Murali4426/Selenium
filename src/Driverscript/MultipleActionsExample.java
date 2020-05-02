package Driverscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MultipleActionsExample {

	public static void main(String[] args) {
		String URL="http://www.myntra.com/";		
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
        
     // get the reference for Web Element Email
        WebElement userName = driver.findElement(By.id("email"));

        // Handling Multiple Actions
        Actions act = new Actions(driver);
        Action seriesOfActions = act.moveToElement(userName).click().keyDown(userName, Keys.SHIFT)
              .sendKeys(userName, "hello").keyUp(userName, Keys.SHIFT).doubleClick(userName).contextClick().build();
        seriesOfActions.perform();

        // Closing current driver window
        driver.close();

	}

}
