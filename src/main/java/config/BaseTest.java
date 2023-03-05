package config;

import helpers.Attachments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import steps.Selectors;

import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;

public class BaseTest {

    Attachments attachments = new Attachments();
    Properties properties = new Properties();

    @BeforeAll
    static void configure() {
        Properties.settingsSelenoid();
        Properties.settingsJenkins();
    }

    @BeforeEach
    void configureBeForeEach() {
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