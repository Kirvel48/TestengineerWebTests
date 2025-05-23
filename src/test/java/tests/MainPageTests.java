package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Smoke")
    @DisplayName("Отображение результата поиска")
    void searchResultPositiveTest() {
        step("Open main page", () -> mainPage.openPage());
       step("Set search request", () -> mainPage.setValueSearchInput("Java"));
        step("Check search result" ,() -> mainPage.checkValueHeaderModule("Java"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Переход на вторую страницу поиска")
    void searchResultPaginationTest() {

        step("Open main page", () -> mainPage.openPage());
        step("Set search request", () -> mainPage.setValueSearchInput("Java"));
        step("Click pagination button" ,() ->mainPage.paginationButtonClick("2"));
        step("Check result" ,() ->mainPage.checkValueHeaderModule("Java"));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Smoke")
    @DisplayName("Переход на статью из поисковой выдачи")
    void searchResultOpenNewsTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Set search request", () -> mainPage.setValueSearchInput("Новые функции Java для автоматизаторов"));
        step("Click news button",() ->mainPage.newsButtonClick());
        step("Check search result" ,() -> newsPage.checkValueHeaderNewsModule("Новые функции Java для автоматизаторов"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Smoke")
    @DisplayName("Переход на страницу новостей из бокового меню")
    void openNewsPageTest() {
        step("Open main page", () -> mainPage.openPage());
        step("Click news button in block menu",() -> mainPage.newsButtonBlockMenuClick());
        step("Check URL page" ,() ->mainPage.checkUrlPage("https://testengineer.ru/category/testing-news/"));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Количество статей на странцие поисковой выдачи")
    void searchResultSizeTest() {

        step("Open main page", () -> mainPage.openPage());
        step("Set search request", () -> mainPage.setValueSearchInput("Java"));
        step("Check result size" ,() -> mainPage.checkNewsPageCollectionsSize(10));

    }


}