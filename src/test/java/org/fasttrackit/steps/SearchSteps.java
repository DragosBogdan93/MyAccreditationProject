package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.SearchPage;

public class SearchSteps {
    private SearchPage searchPage;
    private HomePage homePage;

    @Step
    public void searchForKeyword(String keyword) {
        homePage.open();
        homePage.setSearchField(keyword);
        homePage.clickSearch();

    }

    @Step
    public void checkProductInResult(String productName) {
        searchPage.checkTheSearchResult(productName);
    }
}

