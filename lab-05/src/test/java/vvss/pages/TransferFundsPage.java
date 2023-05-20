package vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import vvss.utils.WebConstants;

import java.time.Duration;

@DefaultUrl(WebConstants.transferFundsPageUrl)
public class TransferFundsPage extends PageObject {
    @FindBy(id = "amount")
    private WebElementFacade amountField;

    @FindBy(id = "fromAccountId")
    private WebElementFacade fromAccount;
    @FindBy(id = "toAccountId")
    private WebElementFacade toAccount;
    @FindBy(css = "input[type='submit']")
    private WebElementFacade submitButton;

    @FindBy(id = "newAccountId")
    private WebElementFacade accountId;

    @FindBy(css = "div#bodyPanel ul li:last-child")
    private WebElementFacade logoutButton;

    public void logout() {
        logoutButton.waitUntilEnabled().click();
    }

    public void transferFunds() {
        amountField.waitUntilEnabled().sendKeys("12");
        withTimeoutOf(Duration.ofSeconds(3))
                .find(By.id("fromAccountId"))
                .selectByIndex(0);
        withTimeoutOf(Duration.ofSeconds(3))
                .find(By.id("toAccountId"))
                .selectByIndex(0);
        withTimeoutOf(Duration.ofSeconds(3))
                .find(By.cssSelector("input[type='submit']"))
                        .click();

//        submitButton.withTimeoutOf(Duration.ofSeconds(2)).click();
    }

    public Boolean isFundsTransfered() {
        return amountField.withTimeoutOf(Duration.ofSeconds(3)).isVisible();
    }
}
