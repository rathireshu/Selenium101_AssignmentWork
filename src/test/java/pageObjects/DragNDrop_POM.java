package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragNDrop_POM {

	WebDriver driver;

	public DragNDrop_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li/a[text()='Drag & Drop Sliders']")
	WebElement dragDropSlidersLink;

	@FindBy(xpath = "//h4[text()=' Default value 15']/following-sibling::div")
	WebElement defaultValue15Slider;

	@FindBy(xpath = "//h4[text()=' Default value 15']/following-sibling::div/input")
	WebElement defaultValue15Input;

	@FindBy(xpath = "//h4[text()=' Default value 15']/following-sibling::div/output")
	WebElement defaultValue15Output;

	public void clickOnDragDropSliders() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dragDropSlidersLink)).click();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void dragDrop() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(defaultValue15Slider));
		Actions actions = new Actions(driver);
		// Perform drag and drop
		actions.clickAndHold(defaultValue15Input).moveByOffset(215, 0).release().perform();
	}

	public String getSliderOutputRange() {
		return defaultValue15Output.getText();
	}
}
