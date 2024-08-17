package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.DragNDrop_POM;

public class DragNDrop_Test2 extends BaseTest {

	@Test(description = "test Scenario 2")
	public void testScenario2() {
		WebDriver driver = getDriver();
		DragNDrop_POM dragNDropPage = new DragNDrop_POM(driver);
		dragNDropPage.clickOnDragDropSliders();
		Assert.assertTrue(dragNDropPage.getPageUrl().contains("drag-drop-range-sliders-demo"));
		dragNDropPage.dragDrop();
		String actualSliderOutputRange = "95";
		Assert.assertEquals(actualSliderOutputRange, dragNDropPage.getSliderOutputRange());
	}

}