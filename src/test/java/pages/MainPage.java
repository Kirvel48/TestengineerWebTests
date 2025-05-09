package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private final SelenideElement searchInput = $(".tdb-head-search-form-input");
    private final SelenideElement headerModule = $(".td-module-meta-info");
    private final SelenideElement firstNewsButton = $(".td-module-thumb");
    private final SelenideElement newsButtonBlockMenu = $(".simple-news__show-more-btn");
    private final ElementsCollection newsCollection = $$(".tdb_module_loop");

    private SelenideElement getPaginationButton(String pageNumber) {
        return (SelenideElement) $$(".page").findBy(text(pageNumber));
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
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        newsCollection.shouldHave(CollectionCondition.size(value));
        return this;
    }
}
