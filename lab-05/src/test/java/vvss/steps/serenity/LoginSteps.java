package vvss.steps.serenity;

import net.thucydides.core.annotations.Step;
import vvss.pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    LoginPage loginPage;

    @Step("Create valid login test with email:{0}, password {1}")
    public void welcomeIsVisibleAfterLogin(String email, String password) {
        loginPage.open();
        loginPage.login(email, password);
        assertTrue(loginPage.welcomeIsVisible());
    }

    @Step("Create invalid login test with email:{0}, password {1}")
    public void welcomeIsNotVisibleAfterLogin(String email, String password) {
        loginPage.open();
        loginPage.login(email, password);
        assertTrue(loginPage.loginFailedTextIsVisible());
    }
}
