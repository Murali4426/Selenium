package Driverscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverExample {

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

        // Mouse Over On " Men link "
        Actions act = new Actions(driver);
        By testlink = By.linkText("Men");
        WebElement test = driver.findElement(testlink);
        act.moveToElement(test).build().perform();

        // Click on " bags & backpacks " link
        //driver.findElement(By.linkText("Bags & Backpacks")).click();
        
        driver.findElement(By.linkText("Headphones")).click();

        // Click on the categories - Bag-packs
        //driver.findElement(By.xpath("//*[text()='Categories']//following::li[1]/label")).click();
        driver.findElement(By.xpath("//*[@id='desktopSearchResults']/div[2]/section/ul/li[1]/a/div[2]")).click();
      
        // Mouse Hover on the 1st bag
        Actions sel = new Actions(driver);
      
        //sel.moveToElement(driver.findElement(By.xpath("//ul[@class='results small']/li[1]"))).build().perform();
        sel.moveToElement(driver.findElement(By.xpath("//*[@id='desktopSearchResults']/div[2]/section/ul/li[1]/div[4]/span[1]/span"))).build().perform();

        // Click on the "Add to Bag" icon of the 1st bag
        driver.findElement(By.xpath("//ul[@class='results small']/li[1]/div[1]//div")).click();

        // Hover over the shopping bag icon present on the top navigation bar
        Actions mov = new Actions(driver);
        mov.moveToElement(driver.findElement(By.xpath("//a[contains(@class, 'cart')]//div"))).click().build().perform();

        // Click on the remove icon
        driver.findElement(By.xpath("(//span[@data-hint='REMOVE FROM BAG'])[1]")).click();

        // Closing current driver window
        driver.close();

	}

}
