package vvss.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import vvss.steps.serenity.OpenAccountAndTransferFundsSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/java/vvss/utils/validLoginData.csv")
public class OpenAccountAndTransferFundsTest {
    @Managed(uniqueSession = true, driver = "firefox")
    public WebDriver webDriver;
    private String username;

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

    private String password;

    @Steps
    public OpenAccountAndTransferFundsSteps openAccountAndTransferFundsSteps;

    @Test
    public void openAccountAndTransferFundsTest() throws InterruptedException {
        openAccountAndTransferFundsSteps.login(username, password);
        openAccountAndTransferFundsSteps.openNewAccount();
        openAccountAndTransferFundsSteps.transferFunds();
        openAccountAndTransferFundsSteps.logout();
    }
}
