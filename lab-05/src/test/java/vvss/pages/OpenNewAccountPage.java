package vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import vvss.utils.WebConstants;

import java.time.Duration;


@DefaultUrl(WebConstants.openNewAccountPageUrl)
public class OpenNewAccountPage extends PageObject {
    @FindBy(css = "input[type='submit']")
    private WebElementFacade submitButton;

    @FindBy(id = "type")
    private WebElementFacade typeSelect;

    @FindBy(id = "fromAccountId")
    private WebElementFacade fromAccountSelect;

    @FindBy(id = "newAccountId")
    private WebElementFacade accountId;
    public void openNewAccount() {
        typeSelect.selectByVisibleText("SAVINGS");
        fromAccountSelect.waitUntilEnabled().selectByIndex(0);
        submitButton.waitUntilClickable().click();
    }

    public Boolean isAccountOpened() {
        return accountId.withTimeoutOf(Duration.ofSeconds(5)).isVisible();
    }
}
