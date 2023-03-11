package config;

import helpers.Attachments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;

public class BaseTest {

    Attachments attachments = new Attachments();
    Properties properties = new Properties();

    @BeforeEach
    void configureBeForeEach() {
        properties.settingsSelenoid();
        properties.settingsJenkins();
        properties.settingAllure();
    }


    @AfterEach
    void addAttachments() {
        attachment("Source", webdriver().driver().source());
        attachments.takeScreenshot();
        attachments.pageSource();
        attachments.browserConsoleLogs();
        attachments.addVideo();

    }
}