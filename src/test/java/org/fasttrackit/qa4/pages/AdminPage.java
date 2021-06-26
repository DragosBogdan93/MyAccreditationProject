package org.fasttrackit.qa4.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;


@DefaultUrl("http://qa4.fasttrackit.org:8008/wp-admin/")
public class AdminPage extends PageObject {

    @FindBy(id = "user_login")
    private WebElementFacade usernameField;
    @FindBy(id = "user_pass")
    private WebElementFacade passwordField;
    @FindBy(id = "wp-submit")
    private WebElementFacade logInButton;
    @FindBy(css = ".menu-icon-comments.menu-top-last a")
    private WebElementFacade commentsLink;
    @FindBy(css = "#the-comment-list .comment.column-comment.has-row-actions.column-primary .row-actions .approve a")
    private WebElementFacade approveCommentLink;
    @FindBy(css = ".response.column-response div .comments-view-item-link")
    private WebElementFacade viewProductLink;
    @FindBy(css = "tr.comment")
    private List<WebElementFacade> commentsList;


    public void setUsernameField(String value) {
        typeInto(usernameField, value);
    }

    public void setPasswordField(String value) {
        typeInto(passwordField, value);
    }

    public void clickLogInButton() {
        clickOn(logInButton);
    }

    public void clickCommentsLink() {
        clickOn(commentsLink);
    }

    public void clickApproveCommentLink() {
        clickOn(approveCommentLink);
    }

    public void clickViewProductLink() {
        viewProductLink.click();
    }

    public boolean selectAnCommentByAuthor(String name) {
        for (WebElementFacade elementFacade : commentsList) {
            if (elementFacade.findElement(By.cssSelector("td.author.column-author strong")).getText().equalsIgnoreCase(name)) {
                elementFacade.findElement(By.cssSelector(".wp-list-table #the-comment-list .check-column input")).click();
                return true;
            }
        }
        return false;
    }
}