package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.NewsPage;

import static io.qameta.allure.Allure.step;

@Epic("Страница статьи")
@Feature("UI|Страница статьи")
@DisplayName("Тесты на отображение страницы статьи")
public class NewsPageTests extends TestBase {
    NewsPage newsPage = new NewsPage();

    @Test
    @Severity(SeverityLevel.MINOR)
    @Tag("All")
    @DisplayName("Отображение логотипа статьи во весь экран")
    void openPicNewsPageTest() {
        step("Open page", () -> newsPage.openNewsPage());
        step("Click on picture", () -> newsPage.picInNewsClick());
        step("Check picture fullscreen visible", () -> newsPage.picFullscreenVisible());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Smoke")
    @DisplayName("Отображение поля email при переходе к комментарию статьи")
    void emailFieldInCommentInputVisibleTest() {
        step("Open page", () -> newsPage.openNewsPage());
        step("Click comment button", () -> newsPage.commentButtonClick());
        step("Check email field visible", () -> newsPage.emailFieldVisible());
    }
}
