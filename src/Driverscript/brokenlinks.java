package Driverscript;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class brokenlinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Variable declaration
				//String URL="http://demo.guru99.com/test/newtours/";
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
		        System.out.println("Number of elements:" + elements.size());
		        
		        //used for loop to 
		        for(int i=0; i<elements.size(); i++) {
			        WebElement element = elements.get(i);
			        //By using "href" attribute, we could get the url of the requried link
			        String url=element.getAttribute("href");
			        //calling verifyLink() method here. Passing the parameter as url which we collected in the above link
			        //See the detailed functionality of the verifyLink(url) method below
			        verifyLink(url); 
		        } 
		        
		       
		        
		       //To get the executing system operating system 
		        String os = System.getProperty("os.name");
		        System.out.println("Executing  System OS Property: " + os);
		        
		        driver.quit();
		        
	}
		     // The below function verifyLink(String urlLink) verifies any broken links and return the server status. 
		        public static void verifyLink(String urlLink) {
		        	  //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
		               try {
		        //Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
		        URL link = new URL(urlLink);
		        // Create a connection using URL object (i.e., link)
		        HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
		        //Set the timeout for 2 seconds
		        httpConn.setConnectTimeout(2000);
		        //connect using connect method
		        httpConn.connect();
		        //use getResponseCode() to get the response code. 
		        if(httpConn.getResponseCode()== 200) { 
		        System.out.println(urlLink+" - "+httpConn.getResponseMessage()+"-"+httpConn.getResponseCode());
		        
		        }else if(httpConn.getResponseCode()== 404) {
		        System.out.println(urlLink+" - "+httpConn.getResponseMessage()+"-"+httpConn.getResponseCode());
		        
		        }
		        }
		        //getResponseCode method returns = IOException - if an error occurred connecting to the server. 
		        catch (Exception e) {
		        //e.printStackTrace();
		        }
		               
		           } 

	}

	