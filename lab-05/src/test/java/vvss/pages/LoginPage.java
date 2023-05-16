package vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import vvss.utils.WebConstants;


@DefaultUrl(WebConstants.loginPageUrl)
public class LoginPage extends PageObject {
    @FindBy(name = "email")
    private WebElementFacade emailInput;
    @FindBy(name = "password")
    private WebElementFacade passwordInput;
    @FindBy(css = "button[type='submit']")
    private WebElementFacade loginButton;

    @FindBy(className = "author__meta")
    private WebElementFacade welcomeText;
    @FindBy(className = "failed")
    private WebElementFacade loginFailedText;

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.waitUntilClickable().click();
    }

    public Boolean welcomeIsVisible() {
        return welcomeText.waitUntilVisible().isVisible();
    }

        public Boolean loginFailedTextIsVisible() {
        return loginFailedText.waitUntilVisible().isVisible();
    }
}
