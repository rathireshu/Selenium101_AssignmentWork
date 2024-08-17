package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleFormDemo_POM {

	WebDriver driver;
	public SimpleFormDemo_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Simple Form Demo']")
	WebElement simpleFormDemoLink;
	@FindBy(id = "user-message")
	WebElement enterMessageTextBox;
	@FindBy(id = "showInput")
	WebElement getCheckedValBtn;
	@FindBy(xpath = "//div[@id='user-message']/p")
	WebElement yourMessageRHP;

	public boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}

	public void clickOnSimpleFormDemo() {
		simpleFormDemoLink.click();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void enterMsg(String msgToEnter) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(enterMessageTextBox)).sendKeys(msgToEnter);
	}

	public void clickOnGetCheckedValBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(getCheckedValBtn)).click();
	}

	public String getYourMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(yourMessageRHP)).getText();
	}
}
