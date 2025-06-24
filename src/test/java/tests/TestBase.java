package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {


    @BeforeAll
    static void getProperties() {
        WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        String browserSize = System.getProperty("browserSize");
        if (browserSize != null) {
            Configuration.browserSize = browserSize;
        } else
            Configuration.browserSize = webDriverConfig.browserSize();

        String browserVersion = System.getProperty("browserVersion");
        if (browserVersion != null) {
            Configuration.browserVersion = browserVersion;
        } else
            Configuration.browserVersion = webDriverConfig.browserVersion();

        String browser = System.getProperty("browser");
        if (browser != null) {
            Configuration.browser = browser;
        } else
            Configuration.browser = webDriverConfig.browserName();

        String remoteUrl = System.getProperty("remote");
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
        } else
            Configuration.remote = webDriverConfig.remoteUrl();

        String baseUrl = System.getProperty("baseUrl");
        if (baseUrl != null) {
            Configuration.baseUrl = baseUrl;
        } else {
            Configuration.baseUrl = "https://testengineer.ru";
        }

        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}