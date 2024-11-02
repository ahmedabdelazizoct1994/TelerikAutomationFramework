package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage {
    private By freeTrialButton =By.xpath("//a[@class='TK-Button TK-Button--CTA']");

            //By.xpath("//a[contains(text(),'Get a Free Trial')]");


    public Homepage(WebDriver driver) {
        super(driver);
    }

    public void clickFreeTrial() {
        clickElement(freeTrialButton);
    }
}
