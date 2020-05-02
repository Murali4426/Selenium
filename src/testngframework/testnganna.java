package testngframework;

import org.testng.annotations.BeforeSuite;

public class testnganna {
	
	//First of all, beforeSuite() method is executed only once.
		@BeforeSuite
		   public void beforeSuite() {
		      System.out.println("in beforeSuite");
		   }


}
