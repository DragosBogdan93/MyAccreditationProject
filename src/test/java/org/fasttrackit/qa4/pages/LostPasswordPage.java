package org.fasttrackit.qa4.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class LostPasswordPage extends PageObject {

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successResetPasswordMessage;
    @FindBy(id = "user_login")
    private WebElementFacade usernameOrEmailField;
    @FindBy(css = ".woocommerce-Button.button")
    private WebElementFacade resetPasswordButton;
    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade errorMessageText;

    public void setUsernameOrEmailField(String usernameOrEmail) {
        typeInto(usernameOrEmailField, usernameOrEmail);
    }

    public void clickResetPasswordButton() {
        clickOn(resetPasswordButton);
    }

    public void checkResetPasswordEmailIsSend() {
        successResetPasswordMessage.shouldContainOnlyText("Password reset email has been sent.");
    }

    public void verifyErrorMessageIsDisplayed() {
        errorMessageText.shouldContainOnlyText("Invalid username or email.");
    }
}
