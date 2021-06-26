package org.fasttrackit.qa4.features;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.qa4.steps.HomeSteps;
import org.fasttrackit.qa4.steps.SearchSteps;
import org.fasttrackit.qa4.utils.BaseTest;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;
    @Steps
    private HomeSteps homeSteps;

    @Test
    public void searchByValidKeyword() {
        homeSteps.navigateToHomepage();
        searchSteps.searchByKeyword("T-SHIRT");
        searchSteps.verifyResultsContains("T-SHIRT new green");
    }

    @Test
    public void verifySortByPrice() {
        homeSteps.navigateToHomepage();
        searchSteps.searchByKeyword("HOODIE");
        searchSteps.verifySortByPriceAscending();
    }

    @Test
    public void searchForNonExistentProduct() {
        homeSteps.navigateToHomepage();
        searchSteps.searchByKeyword("alabala");
        searchSteps.verifyMessageIsDisplay();
    }
}
