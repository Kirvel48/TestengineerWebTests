package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private final SelenideElement searchInput = $(".tdb-head-search-form-input");
    private final SelenideElement headerModule = $(".td-module-meta-info");
    private final SelenideElement firstNewsButton = $(".td-module-thumb");
    private final SelenideElement newsButtonBlockMenu = $(".simple-news__show-more-btn");
    private final ElementsCollection newsCollection = $$(".tdb_module_loop");
    private final SelenideElement firstNewsInDiscussionBlock = $(".td-block-span12");
    private final ElementsCollection commentsList = $$(".wpd-thread-list .wpd-blog-guest");
    private final SelenideElement loginModal = $(".tdb-head-usr-log-txt");
    private final SelenideElement emailLogin = $("#login_email");
    private final SelenideElement passwordlogin = $("#login_pass");
    private final SelenideElement loginButton = $("#login_button");
    private final SelenideElement errorMessage = $(".td_display_err");


    private SelenideElement getPaginationButton(String pageNumber) {
        return $$(".page").findBy(text(pageNumber));
    }

    public void paginationButtonClick(String pageNumber) {
        getPaginationButton(pageNumber).click();
    }

    public MainPage openPage() {
        open("");
        return this;
    }

    public MainPage setValueSearchInput(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

    public MainPage checkValueHeaderModule(String value) {
        headerModule.shouldHave(text(value));
        return this;
    }

    public MainPage newsButtonClick() {
        firstNewsButton.click();
        return this;
    }

    public MainPage newsButtonBlockMenuClick() {
        newsButtonBlockMenu.click();
        return this;
    }

    public MainPage checkUrlPage(String value) {
        webdriver().shouldHave(url(value));
        return this;
    }

    public MainPage checkNewsPageCollectionsSize(Integer value) {
        newsCollection.shouldHave(CollectionCondition.size(value));
        return this;
    }

    public MainPage firstNewsInDiscussionBlockClick() {
        firstNewsInDiscussionBlock.click();
        return this;
    }

    public MainPage checkCommentsListCollectionsSize(Integer value) {
        commentsList.shouldHave().shouldHave(CollectionCondition.sizeGreaterThan(value));
        return this;
    }

    public MainPage loginModalClick() {
        loginModal.click();
        return this;
    }

    public MainPage setLoginValue(String value) {
        emailLogin.setValue(value);
        return this;
    }

    public MainPage setPasswordValue(String value) {
        passwordlogin.setValue(value);
        return this;
    }

    public MainPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public MainPage checkErrorMessage(String value) {
        errorMessage.shouldBe(text(value));
        return this;
    }

}
