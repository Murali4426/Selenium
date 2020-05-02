package testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTestUsingAnnotation {

	String message = "Testmessage";
	MessageUtil messageUtil = new MessageUtil(message);

	   @Test
	   public void testPrintMessage() {
	      System.out.println("Inside testPrintMessage()");
	      message = "Testmessage";
	      Assert.assertEquals(message, messageUtil.printMessage());
	   }

	   @Test(dependsOnMethods = { "initEnvironmentTest" })
	   public void testSalutationMessage() {
	      System.out.println("Inside testSalutationMessage()");
	      message = "tutorialspoint" + "Testmessage";
	      Assert.assertEquals(message, messageUtil.salutationMessage());
	   }

	   @Test
	   public void initEnvironmentTest() {
	      System.out.println("This is initEnvironmentTest");
	   }
}
