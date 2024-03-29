package vvss.steps.serenity;

import net.thucydides.core.annotations.Step;
import vvss.pages.*;
import vvss.utils.WebConstants;

import static org.junit.Assert.assertTrue;

public class OpenAccountAndTransferFundsSteps {
    LoginPage loginPage;
    OpenNewAccountPage openNewAccountPage;
    TransferFundsPage transferFundsPage;

    @Step
    public void login(String username, String password) {
        loginPage.open();
        loginPage.login(username, password);
    }

    @Step
    public void openNewAccount() throws InterruptedException {
//        profilePage.openNewAccountClick();
        openNewAccountPage.open();
        openNewAccountPage.openNewAccount();
    }

    @Step
    public void transferFunds() {
        transferFundsPage.open();
        transferFundsPage.transferFunds();
        assertTrue(transferFundsPage.isFundsTransfered());
    }

    @Step
    public void logout() {
        transferFundsPage.logout();
        //assertTrue(transferFundsPage.loginFormIsVisible());
    }
}
