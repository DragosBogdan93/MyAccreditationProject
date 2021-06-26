package org.fasttrackit.qa4.steps;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.qa4.pages.HomePage;
import org.fasttrackit.qa4.pages.SearchResultsPage;
import org.junit.Assert;

public class SearchSteps {

    private SearchResultsPage searchResultsPage;
    private HomePage homePage;

    @Step
    public void searchByKeyword(String value) {
        homePage.clickSearchIcon();
        homePage.setSearchField(value);
        homePage.clickSecondSearchIcon();
    }

    @Step
    public void verifyResultsContains(String productName) {
        Assert.assertTrue("The product was not found!", searchResultsPage.isProductInList(productName));
    }

    @Step
    public void setSortByPrice() {
        searchResultsPage.setSortByDropdown("Sort by price: low to high");
    }
    @Step
    public void verifySortByPriceAscending() {
        setSortByPrice();
        Assert.assertTrue(searchResultsPage.isSortByPriceAscending());
    }

    @Step
    public void verifyMessageIsDisplay() {
        searchResultsPage.verifyMessageIsDisplay();
    }
}

