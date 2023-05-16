package vvss.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import vvss.steps.serenity.SearchVisaSteps;

@RunWith(SerenityRunner.class)
public class VisaFlowTest {
    @Managed(uniqueSession = true, driver = "firefox")
    public WebDriver webDriver;

    @Steps
    public SearchVisaSteps visaSteps;

    @Test
    public void visaFlowTest() {
        visaSteps.searchVisa();
    }
}
