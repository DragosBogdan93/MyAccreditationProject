package org.fasttrackit.qa4.features;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.qa4.steps.HomeSteps;
import org.fasttrackit.qa4.steps.LostPasswordSteps;
import org.fasttrackit.qa4.steps.MyAccountSteps;
import org.fasttrackit.qa4.utils.BaseTest;
import org.fasttrackit.qa4.utils.Constants;
import org.junit.Before;
import org.junit.Test;

public class LostPasswordTest extends BaseTest {

    @Steps
    private MyAccountSteps myAccountSteps;
    @Steps
    private HomeSteps homeSteps;
    @Steps
    private LostPasswordSteps lostPasswordSteps;

    @Before
    public void navigateToLostPasswordOption() {
        homeSteps.navigateToLogin();
        myAccountSteps.clickLostYourPassword();
    }

    @Test
    public void resetPassword() {
        lostPasswordSteps.enterCredential(Constants.USER_EMAIL);
        lostPasswordSteps.clickResetPassword();
        lostPasswordSteps.checkResetPasswordEmailIsSend();
    }

    @Test
    public void resetPasswordWithInvalidCredential() {
        lostPasswordSteps.enterCredential(Constants.INVALID_EMAIL_FORMAT);
        lostPasswordSteps.clickResetPassword();
        lostPasswordSteps.verifyErrorMessageIsDisplayed();
    }
}
