package org.fasttrackit.qa4.features;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.qa4.steps.HomeSteps;
import org.fasttrackit.qa4.utils.BaseTest;
import org.junit.Test;

public class HomeTest extends BaseTest {

    @Steps
    private HomeSteps homeSteps;

    @Test
    public void searchByValidKeyword() {
        homeSteps.navigateToHomepage();
        homeSteps.searchByKeyword("T-shirt");
        homeSteps.clickSearch();
        homeSteps.checkResultsContains("Blue T-shirt");
    }

    @Test
    public void searchByInvalidValue() {
        homeSteps.navigateToHomepage();
        homeSteps.searchByKeyword("Testing not found results");
        homeSteps.clickSearch();
        homeSteps.verifyMessageIsDisplay("NOTHING FOUND");
    }
}
