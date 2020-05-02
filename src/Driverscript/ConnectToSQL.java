package Driverscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConnectToSQL {

	public static void main(String[] args) {
		// JDBC driver name and database URL
		   final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
		   final String DB_URL = "jdbc:oracle:thin:@//QADB.NEWCORP.COM:1550/QA";

		   //  Database credentials
		   final String USER = "QAAUTOMT";
		   final String PASS = "Welcome789#";
		   Map map=null;

		   Connection conn = null;
		   Statement stmt = null;
		   ResultSet resultSet =null;
		   
		   System.setProperty("webdriver.chromedriver.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
	        ChromeOptions options = new ChromeOptions();
	        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	        //WebDriver driver = new FirefoxDriver();
	        WebDriver driver = new ChromeDriver(options);
	        
		   try{
		      //STEP 2: Register JDBC driver
		      //Class.forName("com.mysql.cj.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "select * from XX_AUTOMATION_EXE_RESULTS where CLIENT_NAME='aafes' and APPLICATION='CareCentral' and BUILD_NUMBER='1'";
		      resultSet = stmt.executeQuery(sql);
		      System.out.println("result set..."+resultSet.toString());
		      
		      
		   // Get the all row of UI Table
				List<WebElement> lstTr = driver.findElement(By.id("grdData")).findElements(By.tagName("tr"));

				// Index for Row
				int rowCount = 0;

				// Count of Matched Column
				int matchColumnCount = 0;

				// Count of Matched Row
				int matchRowCount = 0;

				System.out.println("Row Count => " + lstTr.size());
				
				// Extract the data from Table
				while (resultSet.next()) {

				
				//(rowCount + 1) because first row is a header row , Get all the columns from a particular row
				List<WebElement> lstTd = lstTr.get(rowCount + 1).findElements(By.tagName("td"));
				System.out.println("Cloumn Count => " + lstTd.size());

				for (int j = 0; j < lstTd.size(); j++) {
					String uiCell = lstTd.get(j).getText();
					System.out.println("UI Cell Data => " + uiCell);

					/*
					* (j + 1) in the resultSet => because index is start from 1
					* and here loop is starting from 0
					*/
					String dbCell = resultSet.getString(j + 1);
					System.out.println("DB Cell Data => " + dbCell);

					// Comparison between both string
					if (uiCell.trim().equalsIgnoreCase(dbCell.trim())) {
						matchColumnCount++;
					}
				}
					
				if (matchColumnCount == lstTd.size()) {
					matchRowCount++;
					System.out.println("========ROW MATCHED==========");
				}

				// Set 'matchColumnCount' to 0 for next row	matchColumnCount = 0;
					rowCount++;
				}
			resultSet.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Result Query"+map.toString());
		}//end main
		}