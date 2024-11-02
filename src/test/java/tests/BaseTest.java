package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;
import utils.ReportManager;
import utils.WebDriverManagerUtil;

public class BaseTest {
    protected WebDriver driver;


    @BeforeClass
    public void setUp() {
        ReportManager.initializeReport();
        driver = WebDriverManagerUtil.getDriver();
        driver.get(ConfigReader.getProperty("url"));
        acceptCookiesIfPresent();
    }

    private void acceptCookiesIfPresent() {
        try {
            Thread.sleep(7000);
            By acceptCookiesButton = By.id("onetrust-accept-btn-handler");
            driver.findElement(acceptCookiesButton).click();
        } catch (NoSuchElementException | InterruptedException e) {
            System.out.println("No cookies prompt displayed.");
        }
    }

    @AfterClass
    public void tearDown() {
        WebDriverManagerUtil.quitDriver();
        ReportManager.flushReport();
    }
}
