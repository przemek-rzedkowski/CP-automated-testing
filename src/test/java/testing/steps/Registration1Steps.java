package testing.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class Registration1Steps extends CommonSteps {

    @Before
    public void setUpBeforeTestMethod() throws IOException {
        super.setUpBeforeTestMethod();
    }

    @After
    public void tearDownAfterTestMethod() throws Exception {
        super.tearDownAfterTestMethod();
    }

    @When("^Customer is on Registration Page$")
    public void userIsOnRegistrationPage() {
        assertTrue(registration1Page.isLoaded());
    }

    @And("^Customer uses Correct Credentials to register$")
    public void userUsesCorrectCredentials() {
        registration2Page = registration1Page.registerUsingCorrectCredentials();
    }

    @Then("^Customer is able to proceed to step 2 of registration$")
    public void userIsAbleToProceedToStep2() {
        assertTrue(registration2Page.isLoaded());
    }

    @And("^Customer leaves all fields blank$")
    public void userLeavesAllFieldsBlank() {
        registration1Page.leaveFieldsEmpty();
    }

    @Then("^Customer sees three error messages$")
    public void userSeesThreeErrors() {
        assertTrue(registration1Page.areThereThreeErrors());
    }

    @And("^Customer leaves Name field blank$")
    public void userLeavesNameFieldBlank() {
        registration1Page.leaveNameBlank();
    }

    @When("^Customer leaves Last name blank$")
    public void userLeavesLastNameBlank() {
        registration1Page.leaveLastNameBlank();
    }

    @When("^Customer leaves Mail field blank$")
    public void userLeavesMailBlank() {
        registration1Page.leaveMailBlank();
    }

    @When("^Customer uses incorrect email format$")
    public void userUsesIncorrectEmailFormat() {
        registration1Page.typeIncorrectEmailAddress();
    }

    @When("^Customer uses email address that already exists in SF$")
    public void userUsesEmailTaken() {
        registration1Page.typeEmailAlreadyTaken();
    }

    @When("^Customer doesn't tick TnC checkbox$")
    public void userDoesNotTickTNC() {
        registration1Page.doNotTickTNC();
    }

    @When("^Customer doesn't tick PP checkbox$")
    public void userDoesNotTickPP() {
        registration1Page.doNotTickPP();
    }

    @Then("^Customer sees an error message under name field$")
    public void userSeesNameErrorMessage() {
        assertTrue(registration1Page.isNameErrorDisplaying());
    }

    @Then("^Customer sees an error message under last name field$")
    public void userSeesLastNameErrorMessage() {
        assertTrue(registration1Page.isLastNameErrorDisplaying());
    }

    @Then("^Customer sees an error message under email field$")
    public void userSeesEmailErrorMessage() {
        assertTrue(registration1Page.isEmailErrorDisplaying());
    }

    @And("^Customer cannot submit form due to inactive button$")
    public void userCannotSubmitForm() {
        assertTrue(registration1Page.isSubmitAvailable());
    }

    @Then("^Customer submit form$")
    public void userSubmitsForm() {
        onboardingConfirmationPage = registration1Page.userSubmitsForm();
    }

    @And("^Customer sees message that account already exists$")
    public void userSeesMessageThatAccountExists() {
        assertTrue(onboardingConfirmationPage.isLoaded());
    }

    @Then("^Customer sees TnC checkbox's color turned red$")
    public void userSeesTnCCheckboxTurnedRed() {
        assertTrue(registration1Page.isTnCCheckboxRed());
    }

    @Then("^Customer sees PP checkbox's color turned red$")
    public void userSeesPPCheckboxTurnedRed() {
        assertTrue(registration1Page.isPPCheckboxRed());
    }
}
