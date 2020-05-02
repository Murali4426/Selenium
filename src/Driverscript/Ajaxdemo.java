package Driverscript;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajaxdemo {

	public static void main(String[] args) {
		
		String URL="http://demo.guru99.com/test/ajax.html";		
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
        
        By container = By.cssSelector(".container");
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(container));
		
		//Get the text before performing an ajax call
				WebElement noTextElement = driver.findElement(By.className("radiobutton"));
				String textBefore = noTextElement.getText().trim();
				
				//Click on the radio button
				driver.findElement(By.id("yes")).click();
			    
				wait.until(ExpectedConditions.elementToBeClickable(By.id("buttoncheck")));
				
				//Click on Check Button
				driver.findElement(By.id("buttoncheck")).click();
				
				/*Get the text after ajax call*/
				WebElement TextElement = driver.findElement(By.className("radiobutton"));
				wait.until(ExpectedConditions.visibilityOf(TextElement));
				String textAfter = TextElement.getText().trim();
				
				/*Verify both texts before ajax call and after ajax call text.*/
				//Assert.assertNotEquals(textBefore, textAfter);
				if(!(textBefore.equals(textAfter)))
				{
					System.out.println("text Ajax Call Performed");
				}
				
				
				String expectedText = "Radio button is checked and it's value is Yes";
				
				/*Verify expected text with text updated after ajax call*/
				//Assert.assertEquals(textAfter, expectedText);
				if(textAfter.equals(expectedText))
				{
					System.out.println("Ajax Call Performed");
				}
				driver.close();

	}

}
