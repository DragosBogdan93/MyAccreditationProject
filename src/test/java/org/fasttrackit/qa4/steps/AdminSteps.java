package org.fasttrackit.qa4.steps;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.qa4.pages.AdminPage;
import org.fasttrackit.qa4.pages.HomePage;
import org.fasttrackit.qa4.pages.MyAccountPage;
import org.fasttrackit.qa4.pages.ProductPage;
import org.junit.Assert;

public class AdminSteps {

    private AdminPage adminPage;
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private ProductPage productPage;

    @Step
    public void navigateToReviewSection() {
        homePage.open();
        homePage.clickShopLink();
        productPage.clickProduct();
        productPage.clickReviewButton();
    }

    @Step
    public void selectStars(int starsNumber) {
        productPage.selectStarsReview(starsNumber);
    }

    @Step
    public void setReviewText(String reviewText) {
        productPage.setReviewField(reviewText);
    }

    @Step
    public void setName(String name) {
        productPage.setNameField(name);
    }

    @Step
    public void setEmail(String email) {
        productPage.setEmailField(email);
    }

    @Step
    public void clickSubmit() {
        productPage.clickSubmitButton();
    }

    @Step
    public void clickApprove() {
        adminPage.clickApproveCommentLink();
    }

    @Step
    public void verifyCommentWasApprove(String comment) {
        adminPage.clickViewProductLink();
        productPage.clickReviewButton();
        productPage.verifySuccessReview(comment);
    }

    @Step
    public void selectCommentByAuthor(String name) {
        Assert.assertTrue("The author is not exist!", adminPage.selectAnCommentByAuthor(name));
    }

    @Step
    public void navigateToCommentsSection(String username, String password) {
        adminPage.open();
        adminPage.setUsernameField(username);
        adminPage.setPasswordField(password);
        adminPage.clickLogInButton();
        adminPage.clickCommentsLink();
    }
}
