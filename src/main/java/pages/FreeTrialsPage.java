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
        clickElement(tryNowDropdown);
        By optionLocator = By.xpath("//a[@class='u-db'][normalize-space()='" + optionName + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        optionElement.click();
    }
}
