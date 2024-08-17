package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.InputFormDemo_POM;
import pageObjects.SimpleFormDemo_POM;

public class InputFormDemo_Test3 extends BaseTest {

	@Test(description = "test Scenario 3")
	public void testScenario3() {
		WebDriver driver = getDriver();
		InputFormDemo_POM inputFormDemoPage = new InputFormDemo_POM(driver);
		inputFormDemoPage.clickOnInputFormDemo();
		Assert.assertTrue(inputFormDemoPage.getPageUrl().contains("input-form-demo"));
		// inputFormDemoPage.clickOnSubmitBtn();
		// Assert “Please fill in the fields” error message.

		inputFormDemoPage.enterCredintials("demouser", "demouser@test.com", "demo123");
		inputFormDemoPage.enterCompanyNWebsite("Testing Company", "Seleniumtest.com");
		inputFormDemoPage.enterAddress("Apt 78", "street 7", "United States", "mercer", "Texas", "908765");
		inputFormDemoPage.clickOnSubmitBtn();
		String expectedSuccessMsg = "Thanks for contacting us, we will get back to you shortly.";
		Assert.assertTrue(inputFormDemoPage.getSuccessMsgText().equalsIgnoreCase(expectedSuccessMsg));

	}
}
