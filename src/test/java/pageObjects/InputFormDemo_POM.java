package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputFormDemo_POM {

	WebDriver driver;

	public InputFormDemo_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li/a[text()='Input Form Submit']")
	WebElement inputFormDemoLink;
	@FindBy(id = "name")
	WebElement nameInput;
	@FindBy(name = "email")
	WebElement emailInput;
	@FindBy(id = "inputPassword4")
	WebElement passwordInput;
	@FindBy(id = "company")
	WebElement companyName;
	@FindBy(id = "websitename")
	WebElement websiteName;
	@FindBy(id = "country")
	WebElement countryDD;
	@FindBy(id = "inputAddress1")
	WebElement address1;
	@FindBy(id = "inputAddress2")
	WebElement address2;
	@FindBy(name = "city")
	WebElement city;
	@FindBy(id = "inputState")
	WebElement State;
	@FindBy(name = "zip")
	WebElement zip;
	@FindBy(css = "div.text-right button[type='submit']")
	WebElement submitBtn;
	@FindBy(css = ".loginform p")
	WebElement successMsg;

	public void clickOnInputFormDemo() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(inputFormDemoLink)).click();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getTooltipErrorMsg() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    String TooltipErrorMsg = (String) js.executeScript("return arguments[0].validationMessage;", nameInput);	
	    return TooltipErrorMsg;
	}
	
	public void enterCredintials(String name, String email, String password) {
		nameInput.click();
		nameInput.sendKeys(name);
		nameInput.sendKeys(Keys.TAB);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.switchTo().activeElement())).sendKeys(email);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		WebElement nextField = wait.until(ExpectedConditions.elementToBeClickable(driver.switchTo().activeElement()));
		Actions actions = new Actions(driver);
		actions.moveToElement(nextField).click().perform();
		nextField.sendKeys(password);
	}

	public void enterCompanyNWebsite(String cmpny, String website) {
		companyName.sendKeys(cmpny);
		websiteName.sendKeys(website);
	}

	public void enterAddress(String add1, String add2, String Country, String cityName, String stateName,
			String zipcode) {
		// Move to the dd field using TAB
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		// Ensure the dd element is focused ,activated and ready for input
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement countryDropdown = wait
				.until(ExpectedConditions.elementToBeClickable(driver.switchTo().activeElement()));
		Select dd = new Select(countryDropdown);
		dd.selectByVisibleText(Country);
		address1.sendKeys(add1);
		address2.sendKeys(add2);
		city.sendKeys(cityName);
		State.sendKeys(stateName);
		zip.sendKeys(zipcode);
	}
	public void clickOnSubmitBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
	}
	public String getSuccessMsgText() {
		return successMsg.getText();
	}

}
