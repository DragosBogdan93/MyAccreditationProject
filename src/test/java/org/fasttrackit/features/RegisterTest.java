package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.pages.RegisterPage;
import org.fasttrackit.steps.RegisterSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class RegisterTest extends BaseTest {
    @Steps
    private RegisterSteps registerSteps;
    @Test
    public void registerNewUserAccount (){
        registerSteps.navigateToRegister();
        registerSteps.enterCredentials("Dragos","Bogdan","Moise","darsasda@gmail.com","123456","123456");
        registerSteps.clickOnSubscribeNewsletter();
        registerSteps.clickOnRegister();
        registerSteps.checkAccountIsCreated("Thank you for registering with Madison Island.");

    }

    @Test
    public void checkDuplicationAccount() {
        registerSteps.navigateToRegister();
        registerSteps.enterCredentials("Dragoss","Bogdan","Moise","darsasda@gmail.com","123456","123456");
        registerSteps.clickOnSubscribeNewsletter();
        registerSteps.clickOnRegister();
        registerSteps.verifyDuplicateUser("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
    }
}
