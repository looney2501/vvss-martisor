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
@UseTestDataFrom("src/test/java/vvss/utils/validLoginData.csv")
public class LoginValidTest {
    @Managed(uniqueSession = true, driver = "firefox")
    public WebDriver webDriver;

    private String username;
    private String password;

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void loginTest() {
        loginSteps.welcomeIsVisibleAfterLogin(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
