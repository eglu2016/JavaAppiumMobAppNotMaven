package tests.iOS;

import libs.iOSTestCase;
import libs.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends iOSTestCase {
    @Test
    public void testPassThroughWelcome() {
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextLink();

        WelcomePage.waitForNewWaysToExploreText();
        WelcomePage.clickNextLink();

        WelcomePage.waitForAddOrEditPreferredLanguagesLink();
        WelcomePage.clickNextLink();

        WelcomePage.waitForLearnMoreAboutDataCollectedLink();
        WelcomePage.clickGetStartedButton();
    }
}
