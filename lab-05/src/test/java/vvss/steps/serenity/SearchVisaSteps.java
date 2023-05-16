package vvss.steps.serenity;

import net.thucydides.core.annotations.Step;
import vvss.pages.LoginPage;
import vvss.pages.ProfilePage;
import vvss.pages.VisaPage;
import vvss.utils.WebConstants;

import static org.junit.Assert.assertTrue;

public class SearchVisaSteps {
    LoginPage loginPage;
    VisaPage visaPage;
    ProfilePage profilePage;

    @Step
    public void searchVisa() {
        loginPage.open();
        loginPage.login(WebConstants.email, WebConstants.password);
        assertTrue(loginPage.welcomeIsVisible());

        visaPage.open();
        visaPage.searchVisa();
        visaPage.submitVisa();
        assertTrue(visaPage.isVisaSubmittedVisible());

        profilePage.open();
        profilePage.logout();
    }
}
