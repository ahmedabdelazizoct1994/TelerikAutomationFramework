package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage {
    private By freeTrialButton =By.xpath("//a[@class='TK-Button TK-Button--CTA']");


    public Homepage(WebDriver driver) {
        super(driver);
    }
    public void clickFreeTrial() {
        clickElement(freeTrialButton);
    }
}
