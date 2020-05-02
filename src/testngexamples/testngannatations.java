package testngexamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngannatations {
	
	//First of all, beforeSuite() method is executed only once.
	@BeforeSuite
	   public void beforeSuite() {
	      System.out.println("in beforeSuite");
	   }

		
	//Even the methods beforeTest(), beforeClass(), afterClass(), and afterTest() 
	//methods are executed only once.
	@BeforeClass
	   public void beforeClass() {
	      System.out.println("in beforeClass");
	      
	   }

	   @AfterClass
	   public void afterClass() {
	      System.out.println("in afterClass");
	   }

	   @BeforeTest
	   public void beforeTest() {
	      System.out.println("in beforeTest");
	   }

	   @AfterTest
	   public void afterTest() {
	      System.out.println("in afterTest");
	   }
	
	//beforeMethod() method executes for each test case but before executing the test case.
	
	   @BeforeMethod
	   public void beforeMethod() {
	      System.out.println("in beforeMethod");
	   }

	   @AfterMethod
	   public void afterMethod() {
	      System.out.println("in afterMethod");
	   }
    
	
	@Test
	public void testcase1()   
	{  
	System.out.println("Test case1");  
	}  
	@Test
	public void testcase2()   
	{  
	System.out.println("Test case2");  
	}  
//	@Test
//	public void testcase3()   
//	{  
//	System.out.println("Test case3");  
//	}  
}
