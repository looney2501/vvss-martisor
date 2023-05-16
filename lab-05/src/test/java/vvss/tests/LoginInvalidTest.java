package vvss.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import vvss.steps.serenity.LoginSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/java/vvss/utils/invalidLoginData.csv")
public class LoginInvalidTest {
    @Managed(uniqueSession = true, driver = "firefox")
    public WebDriver webDriver;

    private String username;
    private String password;

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void loginTest() {
        loginSteps.welcomeIsNotVisibleAfterLogin(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
