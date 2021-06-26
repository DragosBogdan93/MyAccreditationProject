package org.fasttrackit.qa4.features;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.qa4.utils.Constants;
import org.fasttrackit.qa4.steps.AdminSteps;
import org.fasttrackit.qa4.utils.BaseTest;
import org.junit.Test;

public class AdminTest extends BaseTest {

    @Steps
    private AdminSteps adminSteps;

    @Test
    public void approveAnComment() {
        adminSteps.navigateToReviewSection();
        adminSteps.selectStars(3);
        adminSteps.setReviewText("Please accept the comment");
        adminSteps.setName("Bogdan");
        adminSteps.setEmail(Constants.RANDOM_USER_EMAIL);
        adminSteps.clickSubmit();
        adminSteps.navigateToCommentsSection(Constants.ADMIN_USERNAME, Constants.ADMIN_PASSWORD);
        adminSteps.selectCommentByAuthor("Bogdan");
        adminSteps.clickApprove();
        adminSteps.verifyCommentWasApprove("Please accept the comment");
    }
}







