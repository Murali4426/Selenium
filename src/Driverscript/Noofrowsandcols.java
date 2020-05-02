package Driverscript;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Noofrowsandcols {

	public static void main(String[] args) throws InterruptedException, ParseException {
		//Variable declaration
		String URL="http://demo.guru99.com/test/web-table-element.php";		
		String pageSource1=null;
		String title=null;
		String max;
	    double m=0,r=0;
		
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
        
        Thread.sleep(6000);  
        
        //No.of Columns
        List  col = driver.findElements(By.xpath("//table[@class='dataTable']//tr[1]/th"));
        System.out.println("No of cols are : " +col.size()); 
        //No.of rows 
        List  celldata = driver.findElements(By.xpath("//table[@class='dataTable']//tr//td")); 
        System.out.println("No of rows are : " + celldata.size());
        
        List  rows = driver.findElements(By.xpath("//table[@class='dataTable']//tr")); 
        System.out.println("No of rows are : " + rows.size());
        
        //To find third row of table
        WebElement baseTable = driver.findElement(By.tagName("table"));
        WebElement tableRow  = driver.findElement(By.xpath("//table[@class='dataTable']//tr[3]"));
        
        String rowtext = tableRow.getText();
		System.out.println("Third row of table : "+rowtext);
		
		 //to get 3rd row's 4th column data
		WebElement cellIneed = driver.findElement(By.xpath("//table[@class='dataTable']//tr[3]//td[4]"));
		String valueIneed = cellIneed.getText();
	    System.out.println("Cell value is : " + valueIneed); 
	    
	    
	    //displaying the highest values in column
	    for (int i =1;i<rows.size()-1;i++)
        {    
	        max= driver.findElement(By.xpath("//table[@class='dataTable']//tr[" + (i+1)+ "]/td[4]")).getText();
            NumberFormat f =NumberFormat.getNumberInstance(); 
            Number num = f.parse(max);
            max = num.toString();
            m = Double.parseDouble(max);
            if(m>r)
             {    
                r=m;
             }
        }
        System.out.println("Maximum current price is : "+ r);
        
	    //try to find the 'Bharat Petroleum' and display entire row
	    
	    //Compare previous price and current price and display the company name which are current price > previous price
	    
        driver.close();

	}

}
