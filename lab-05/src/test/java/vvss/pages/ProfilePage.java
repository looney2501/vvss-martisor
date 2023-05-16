package vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import vvss.utils.WebConstants;

@DefaultUrl(WebConstants.profilePageUrl)
public class ProfilePage extends PageObject {
    @FindBy(name = "firstname")
    private WebElementFacade firstNameInput;
    @FindBy(css = "button[type='submit']")
    private WebElementFacade updateButton;
    @FindBy(className = "alert-success")
    private WebElementFacade successAlert;
    @FindBy(id = "cookie_stop")
    private WebElementFacade cookie;
    @FindBy(id = "preloader")
    private WebElementFacade preloader;
    @FindBy(css = "ul.list-items li:last-child")
    private WebElementFacade logoutButton;

    public void update(String firstName, WebDriver webDriver) {
        preloader.waitUntilNotVisible();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        Actions act = new Actions(webDriver);
        act.moveToElement(updateButton);
        cookie.waitUntilClickable().click();
        updateButton.waitUntilVisible().click();
    }

    public void logout() {
        preloader.waitUntilNotVisible();
        logoutButton.waitUntilClickable().click();
    }

    public Boolean successIsVisible() {
        return successAlert.waitUntilVisible().isVisible();
    }
}
