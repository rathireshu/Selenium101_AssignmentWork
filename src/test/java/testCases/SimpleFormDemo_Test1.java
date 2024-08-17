package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.SimpleFormDemo_POM;

public class SimpleFormDemo_Test1 extends BaseTest {

	@Test(description = "test Scenario 1")
	public void testScenario1() {
		WebDriver driver = getDriver();
		SimpleFormDemo_POM simpleFormDemoPage = new SimpleFormDemo_POM(driver);
		simpleFormDemoPage.clickOnSimpleFormDemo();
		Assert.assertTrue(simpleFormDemoPage.getPageUrl().contains("simple-form-demo"));
		String welComeMsg = "Welcome to LambdaTest.";
		simpleFormDemoPage.enterMsg(welComeMsg);
		simpleFormDemoPage.clickOnGetCheckedValBtn();
		Assert.assertTrue(simpleFormDemoPage.getYourMessage().contains(welComeMsg));
	}

}