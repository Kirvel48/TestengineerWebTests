package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewsPage {
    private final SelenideElement picInNews = $(".entry-thumb");

    private final SelenideElement headerNewsModule = $(".tdb-title-text");
    private final SelenideElement picFullscreen = $(".mfp-img");
    private final SelenideElement commentButton = $("#wpd-editor-wraper-0_0");
    private final SelenideElement emailField = $("#wc_email-0_0");

    public NewsPage checkValueHeaderNewsModule(String value) {
        headerNewsModule.shouldHave(text(value));
        return this;
    }

    public NewsPage picInNewsClick() {
        picInNews.click();
        return this;
    }

    public NewsPage openNewsPage() {
        open("/retest-vs-regression-difference/");
        return this;
    }

    public NewsPage picFullscreenVisible() {
        picFullscreen.shouldBe(visible);
        return this;
    }

    public NewsPage commentButtonClick() {
        commentButton.click();
        return this;
    }

    public NewsPage emailFieldVisible() {
        emailField.shouldBe(visible);
        return this;
    }
}
