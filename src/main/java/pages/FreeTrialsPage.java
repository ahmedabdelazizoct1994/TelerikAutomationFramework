//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class FreeTrialsPage extends BasePage {
//    private By tryNowDropdown = By.xpath("//a[@class='Dropdown-control Btn Btn--prim u-fs19 u-mw20 u-p1 u-db u-s-full u-s-mwn']");
//            //.id("tryNowDropdown");
//    private By uiForReactOption=By.xpath("//a[@class='u-db'][normalize-space()='UI for React']")
//
//
//    public FreeTrialsPage(WebDriver driver) {
//        super(driver);
//    }
//
////    public void selectOptionByName(String optionName) {
////        Select select = new Select(findElement(tryNowDropdown));
////        select.selectByVisibleText(optionName);
////    }
//
//    public void selectOptionByName(String optionName) {
//        // Click to open the dropdown
//        findElement(tryNowDropdown).click();
//
//
////        // Find the option by its text and click it
////        By optionLocator = By.xpath("//a[contains(text(), '" + optionName + "')]");
////        findElement(optionLocator).click();
//    }
//
//}


package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FreeTrialsPage extends BasePage {
    private By tryNowDropdown = By.xpath("//a[@class='Dropdown-control Btn Btn--prim u-fs19 u-mw20 u-p1 u-db u-s-full u-s-mwn']");

    public FreeTrialsPage(WebDriver driver) {
        super(driver);
    }

    public void selectOptionFromDropdown(String optionName) {
        // Click on the dropdown to display options
        clickElement(tryNowDropdown);

        // Dynamic XPath for the dropdown option
        By optionLocator = By.xpath("//a[@class='u-db'][normalize-space()='" + optionName + "']");

        // Wait for the option to be clickable and click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        optionElement.click();
    }
}
