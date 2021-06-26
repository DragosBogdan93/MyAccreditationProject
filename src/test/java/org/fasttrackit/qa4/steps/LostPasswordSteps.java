package org.fasttrackit.qa4.steps;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.qa4.pages.LostPasswordPage;

public class LostPasswordSteps {

    private LostPasswordPage lostPasswordPage;

    @Step
    public void enterCredential(String usernameOrEmail) {
        lostPasswordPage.setUsernameOrEmailField(usernameOrEmail);
    }

    @Step
    public void clickResetPassword() {
        lostPasswordPage.clickResetPasswordButton();
    }

    @Step
    public void checkResetPasswordEmailIsSend() {
        lostPasswordPage.checkResetPasswordEmailIsSend();
    }

    @Step
    public void verifyErrorMessageIsDisplayed() {
        lostPasswordPage.verifyErrorMessageIsDisplayed();
    }
}
