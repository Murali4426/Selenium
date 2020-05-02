package Driverscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class selectExamples {

	public static void main(String[] args) {
		String URL="C:\\Training\\test.html";
		
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
        
        
        WebElement element=driver.findElement(By.name("Mobdevices"));
		Select se=new Select(element);
		
		se.selectByVisibleText("Nokia");
		se.selectByVisibleText("HTC");
		
		//To get all the options present in the dropdown
		List<WebElement> allOptions = se.getOptions();
		for (WebElement webElement : allOptions)
		{
			System.out.println(webElement.getText());
		}
		
		
		//To get all the options that are selected in the dropdown.
		List<WebElement> allSelectedOptions = se.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions)
		{
			System.out.println("You have selected::"+ webElement.getText());
		}
		
		//To get the first selected option in the dropdown
		WebElement firstOption = se.getFirstSelectedOption();
		System.out.println("The First selected option is::" +firstOption.getText());
		
		if(se.isMultiple())
		{
		System.out.println("Select tag allows multiple selection");	
		}
		
		driver.quit();

	}

}
