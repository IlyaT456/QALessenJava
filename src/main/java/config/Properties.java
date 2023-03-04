package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Properties {
    public static void settingsSelenoid() {
        //настройки selenoid
        Configuration.driverManagerEnabled = true;
        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability("enableVNC", false);
        Configuration.browserCapabilities.setCapability("enableVideo", false);
        Configuration.browserSize = "1920x1080";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    public static void settingsJenkins() {
        // настройки браузера property – для запуска в дженкинсе
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "110");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
    }

    public Properties settingAllure() {
        // настройки для работы Allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        return this;
    }
}
