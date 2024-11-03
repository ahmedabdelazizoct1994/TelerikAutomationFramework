package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CreateAccountPage extends BasePage {
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By firstNameField = By.id("fist-name");
    private By lastNameField = By.id("last-name");
    private By companyField = By.id("company");
    private By phoneField = By.id("phone");
    private By countryDropdownField = By.xpath("//input[@placeholder='Type to filter']");
    private By createAccountButton = By.xpath("//button[@type='submit']");
    private By thankYouMessage = By.xpath("//h1[contains(text(),'Thank You for Signing Up!')]");
    private By nextButton = By.xpath("//button[@type='submit']");
    private By optionalCheckbox = By.xpath("//input[@type='checkbox']");
    private By captchaIframe = By.id("cf-chl-widget-6psgg");
    private By iframeLocator = By.cssSelector("iframe[src*='cloudflare']");


    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void clickOnNextButton() {
        clickElement(nextButton);
    }

    public void enterPassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void enterFirstName(String firstName) {
        waitForElementToBeVisible(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        findElement(lastNameField).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        findElement(companyField).sendKeys(company);
    }

    public void enterPhone(String phone) {
        findElement(phoneField).sendKeys(phone);
        findElement(phoneField).sendKeys(Keys.TAB);
    }
    public void selectCountry(String countryName) {
        findElement(countryDropdownField).sendKeys(countryName);
        findElement(countryDropdownField).sendKeys(Keys.ENTER);
    }

    public void clickCreateAccountButton() {
    // I created two calls below for the same locator as the behaviour of the CAPTCHA shown after clicking on create button so i need to click on the create button again
        findElement(createAccountButton).click();
        clickCheckboxIfPresent();
        findElement(createAccountButton).click();
    }

//    public String getThankYouMessageText(){
//
//        return findElement(thankYouMessage).getText();
//    }

    public void clickCheckboxIfPresent() {
        try {
            if (findElement(captchaIframe).isDisplayed()) {
                completeCaptchaAndSubmit();

            }
        } catch (Exception e) {
            System.out.println("Optional checkbox not present or not clickable.");
        }
    }

    public void completeCaptchaAndSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //  Switch to the iframe containing the CAPTCHA
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));

        //  Use JavaScript to access the shadow DOM and click the checkbox
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowHost = driver.findElement(By.cssSelector("div[role='alert']"));
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement checkbox = shadowRoot.findElement(By.cssSelector("input[type='checkbox']"));
        checkbox.click();

        // Switch back to the main content
        driver.switchTo().defaultContent();
    }
}
