package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NewsPage;


import static io.qameta.allure.Allure.step;

@Epic("Главная страница")
@Feature("UI|Главная страница")
@DisplayName("Тесты на отображение главной страницы")
@Tag("All")
public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();
    TestData testData = new TestData();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Smoke")
    @Owner("Tetushkin K.I.")
    @DisplayName("Отображение результата поиска")
    void searchResultPositiveTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Set search request", () -> mainPage.setValueSearchInput(testData.searchInputValueSizeTest));
        step("Check search result", () -> mainPage.checkValueHeaderModule(testData.searchInputValueSizeTest));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("Tetushkin K.I.")
    @DisplayName("Переход на вторую страницу поиска")
    void searchResultPaginationTest() {

        step("Open main page", () -> mainPage.openPage());
        step("Set search request", () -> mainPage.setValueSearchInput(testData.searchInputValueSizeTest));
        step("Click pagination button", () -> mainPage.paginationButtonClick(testData.pageNumber));
        step("Check result", () -> mainPage.checkValueHeaderModule(testData.searchInputValueSizeTest));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Smoke")
    @Owner("Tetushkin K.I.")
    @DisplayName("Переход на статью из поисковой выдачи")
    void searchResultOpenNewsTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Set search request", () -> mainPage.setValueSearchInput(testData.searchInputValueOpenNews));
        step("Click news button", () -> mainPage.newsButtonClick());
        step("Check search result", () -> newsPage.checkValueHeaderNewsModule(testData.searchInputValueOpenNews));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Smoke")
    @Owner("Tetushkin K.I.")
    @DisplayName("Переход на страницу новостей из бокового меню")
    void openNewsPageTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Click news button in block menu", () -> mainPage.newsButtonBlockMenuClick());
        step("Check URL page", () -> mainPage.checkUrlPage(testData.urlPage));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("Tetushkin K.I.")
    @DisplayName("Количество статей на странцие поисковой выдачи")
    void searchResultSizeTest() {

        step("Open main page", () -> mainPage.openPage());
        step("Set search request", () -> mainPage.setValueSearchInput(testData.searchInputValueSizeTest));
        step("Check result size", () -> mainPage.checkNewsPageCollectionsSize(testData.pageCollectionsSize));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("Tetushkin K.I.")
    @DisplayName("К новостям из блока Обсуждают есть комментарии")
    void newsFromDiscussionBlockHaveComment() {
        step("Open main page", () -> mainPage.openPage());
        step("Click on first news in Discussion Block", () -> mainPage.firstNewsInDiscussionBlockClick());
        step("Check comments value", () -> mainPage.checkCommentsListCollectionsSize(testData.commentsListSize));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Owner("Tetushkin K.I.")
    @Tag("Smoke")
    @DisplayName("Ошибка при неверном вводе логина/пароля")
    void errorTextIncorrectPassword() {
        step("Open main page", () -> mainPage.openPage());
        step("Open login modal", () -> mainPage.loginModalClick());
        step("Set login", () -> mainPage.setLoginValue(testData.login));
        step("Set password", () -> mainPage.setPasswordValue(testData.password));
        step("Click login button", () -> mainPage.clickLoginButton());
        step("Check error message", () -> mainPage.checkErrorMessage(testData.errorLoginMessage));
    }


}