package vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import vvss.utils.WebConstants;


@DefaultUrl(WebConstants.searchedVisaPageUrl)
public class SearchedVisaPage extends PageObject {
    @FindBy(id = "submit")
    private WebElementFacade submitButton;
    @FindBy(id = "cookie_stop")
    private WebElementFacade cookie;
    @FindBy(id = "preloader")
    private WebElementFacade preloader;

    public void submitVisa() {
        preloader.waitUntilNotVisible();
        cookie.waitUntilClickable().click();
        submitButton.waitUntilClickable().click();
    }
}
