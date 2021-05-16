package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.RegisterPage;

public class RegisterSteps {
    private HomePage homePage;
    private RegisterPage registerPage;
    @Step
    public void navigateToRegister() {
        homePage.open();
        homePage.clickAccountLink();
        homePage.clickRegisterLink();
    }
    @Step
    public void enterCredentials(String lastName,String middleName,String firstName,String email, String password,String samePassword) {
        registerPage.setFirstNameField(firstName);
        registerPage.setMiddleNameField(middleName);
        registerPage.setLastNameField(lastName);
        registerPage.setEmailField(email);
        registerPage.setPasswordField(password);
        registerPage.setPasswordConfirmationField(samePassword);
    }
    @Step
    public void clickOnSubscribeNewsletter () {
        registerPage.clickSubscriebNewsletter();
    }
    @Step
    public void clickOnRegister() {
        registerPage.clickRegisterButton();
    }
    @Step
    public void checkAccountIsCreated(String message){
        registerPage.verifyNewAccountCreate(message);

    }
    @Step
    public void verifyDuplicateUser(String message) {
        registerPage.verifyDuplicateUser(message);
    }
}
