package vvss.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.Keys;
import vvss.utils.WebConstants;

@DefaultUrl(WebConstants.visaPageUrl)

public class VisaPage extends PageObject {
    @FindBy(css = "[aria-labelledby=\"select2-from_country-container\"]")
    private WebElementFacade fromSelect;
    @FindBy(css = "[aria-labelledby=\"select2-to_country-container\"]")
    private WebElementFacade toSelect;
    @FindBy(css = "[aria-controls=\"select2-from_country-results\"]")
    private WebElementFacade fromInput;
    @FindBy(css = "[aria-controls=\"select2-to_country-results\"]")
    private WebElementFacade toInput;
    @FindBy(id = "select2-from_country-result-bokz-RO")
    private WebElementFacade fromRomania;
    @FindBy(id = "select2-to_country-result-cs71-US")
    private WebElementFacade toUS;
    @FindBy(css = "button[type='submit']")
    private WebElementFacade searchButton;
    @FindBy(id = "preloader")
    private WebElementFacade preloader;
    @FindBy(id = "cookie_stop")
    private WebElementFacade cookie;
    @FindBy(id = "submit")
    private WebElementFacade submitButton;
    @FindBy(css = "div.card-body h2")
    private WebElementFacade visaSubmitted;

    public void searchVisa() {
        preloader.waitUntilNotVisible();

        fromSelect.waitUntilClickable().click();
        fromInput.waitUntilEnabled().sendKeys("Romania");
        fromInput.sendKeys(Keys.ENTER);

        toSelect.waitUntilClickable().click();
        toInput.waitUntilEnabled().sendKeys("United States");
        toInput.sendKeys(Keys.ENTER);

        searchButton.waitUntilClickable().click();
    }

    public void submitVisa() {
        preloader.waitUntilNotVisible();
        cookie.waitUntilClickable().click();
        submitButton.waitUntilClickable().click();
    }

    public Boolean isVisaSubmittedVisible() {
        return visaSubmitted.waitUntilVisible().isVisible();
    }
}
