package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegisterPage extends PageObject {
    @FindBy(id = "firstname")
    private WebElementFacade firstNameField;
    @FindBy(id = "middlename")
    private WebElementFacade middleNameField;
    @FindBy(id = "lastname")
    private WebElementFacade lastNameField;
    @FindBy(id = "email_address")
    private WebElementFacade emailField;
    @FindBy(id = "password")
    private WebElementFacade passwordField;
    @FindBy(id = "confirmation")
    private WebElementFacade passwordConfirmationField;
    @FindBy(id = "is_subscribed")
    private WebElementFacade checkNewsletter;
    @FindBy(css = "button[title='Register']")
    private WebElementFacade registerButton;
    @FindBy(css = ".success-msg span")
    private WebElementFacade successMessageSpan;
    @FindBy(css = ".error-msg span")
    private WebElementFacade erroMessageSpan;

    public void setFirstNameField (String firstName) {
        typeInto(firstNameField,firstName);
    }
    public void setMiddleNameField (String middleName) {
        typeInto(middleNameField,middleName);
    }
    public void setLastNameField (String lastName) {
        typeInto(lastNameField,lastName);
    }
    public void setEmailField(String email){
        typeInto(emailField, email);
    }

    public void setPasswordField(String password){
        typeInto(passwordField, password);
    }
    public void setPasswordConfirmationField(String samePassword) {
        typeInto(passwordConfirmationField,samePassword);
    }
    public void clickSubscriebNewsletter(){
        clickOn(checkNewsletter);
    }
    public void clickRegisterButton() {
        clickOn(registerButton);
    }
    public void verifyNewAccountCreate(String message) {
        successMessageSpan.shouldContainOnlyText(message);
    }
    public void verifyDuplicateUser(String message){
        erroMessageSpan.shouldContainOnlyText(message);
    }


}
