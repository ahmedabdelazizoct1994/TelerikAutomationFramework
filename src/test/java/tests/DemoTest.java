package tests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.FreeTrialsPage;
import pages.Homepage;
import utils.ConfigReader;
import utils.ReportManager;

public class DemoTest extends BaseTest {

    @Test
    public void testSignUpForTrial() {
        ReportManager.createTest("Test: Sign Up for Trial");
        ReportManager.getTest().log(Status.INFO, "Navigating to Free Trial page.");

        Homepage homepage = new Homepage(driver);
        homepage.clickFreeTrial();
           ReportManager.getTest().log(Status.INFO, "Selecting option from dropdown.");

        FreeTrialsPage freeTrialsPage = new FreeTrialsPage(driver);
        freeTrialsPage.selectOptionFromDropdown(ConfigReader.getProperty("UiForReact"));
           ReportManager.getTest().log(Status.INFO, "Filling in account creation form.");

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.enterEmail(ConfigReader.getProperty("email"));
        createAccountPage.clickOnNextButton();
        createAccountPage.enterPassword(ConfigReader.getProperty("password"));
        createAccountPage.enterFirstName(ConfigReader.getProperty("firstName"));
        createAccountPage.enterLastName(ConfigReader.getProperty("lastName"));
        createAccountPage.enterCompany(ConfigReader.getProperty("company"));
        createAccountPage.enterPhone(ConfigReader.getProperty("phone"));
        createAccountPage.selectCountry(ConfigReader.getProperty("country"));
        createAccountPage.clickCreateAccountButton();

        ReportManager.getTest().log(Status.INFO, "Verifying thank you message.");
        String thankYouMessage = createAccountPage.getThankYouMessageText();
        Assert.assertEquals(thankYouMessage, "Thank You for Signing Up!", "Sign-up confirmation message mismatch.");
        ReportManager.getTest().log(Status.PASS, "Test completed successfully.");

    }
}