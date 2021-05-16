package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountPage extends PageObject {

    @FindBy(css = ".hello strong")
    private WebElementFacade welcomeMessageParagraph;

    public void verifyWelcomeMessage(String message){
        welcomeMessageParagraph.shouldContainOnlyText(message);
    }

    public boolean isWelcomeTextDisplayed(String text){
        return welcomeMessageParagraph.containsOnlyText(text);
    }

    public String getWelcomeText(){
        return welcomeMessageParagraph.getText();
    }
}
