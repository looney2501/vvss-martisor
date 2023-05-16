//package org.example.tests;
//
//import net.serenitybdd.junit.runners.SerenityRunner;
//import net.thucydides.core.annotations.Managed;
//import net.thucydides.core.annotations.Steps;
//import org.example.steps.serenity.UpdateSteps;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.WebDriver;
//
//@RunWith(SerenityRunner.class)
//public class UpdateTest {
//    @Managed(uniqueSession = true, driver = "firefox")
//    public WebDriver webDriver;
//
//    @Steps
//    public UpdateSteps updateSteps;
//
//    @Test
//    public void updateTest() {
//        updateSteps.successIsVisibleAfterUpdate("johnn", webDriver);
//    }
//}
