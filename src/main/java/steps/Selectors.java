package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.BasePage;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Selectors {

    BasePage page = new BasePage();

    @Step("Открыть главную страницу")
    public Selectors openMainPage() {
        open("https://www.sberbank.com/ru/certificates");
        return this;
    }

    @Step("Открыть главную Яндекс")
    public Selectors openYandex() {
        open("https://dzen.ru/");
        return this;
    }

    @Step("Кликнуть по пункту {0} главного меню")
    public Selectors categoryPanel(String text) {
        page.mainMenu(text).shouldBe(exist, Duration.ofSeconds(30)).click();
        return this;
    }

    @Step("Открыть категорию {0}")
    public Selectors subcategoryMortgage(String text) {
        page.subcategoryMortgage(text).hover().click();
        Set<String> handles = getWebDriver().getWindowHandles();
        Selenide.switchTo().window(handles.size() - 1);
        return this;
    }

    @Step("Выбираем в подкатегории вкладку 'Оплата услуг'")
    public Selectors paymentServicesCategory() {
        page.paymentServicesCategory().findBy(text("Оплата услуг")).click();
        Set<String> handles = getWebDriver().getWindowHandles();
        Selenide.switchTo().window(handles.size() - 1);
        return this;
    }

    @Step("Проверка содержания заголовка {0}")
    public Selectors cheakText(String text) {
        page.mainPage().shouldBe(text(text));
        return this;
    }

    @Step("Поиск вкладки {0}")
    public Selectors searchTab(String text) {
        page.searchTab(text).findBy(text(text)).click();
        return this;
    }

    @Step("Проверка работы кнопкизаявки '{0}")
    public Selectors cheakButtonApplication() {
        page.applicationButton().shouldBe(visible).click();
        Set<String> handles = getWebDriver().getWindowHandles();
        Selenide.switchTo().window(handles.size() - 1);
        return this;
    }

    @Step("Проверка ошибок в консоли 'SEVERE'")
    public Selectors consoleShouldNotHaveErrorsTest() {
        List<String> consoleLogs = Selenide.getWebDriverLogs(BROWSER);
        String errorText = "SEVERE";
        Assertions.assertFalse(consoleLogs.contains(errorText));
        return this;
    }

    @Step("Проверка соответсвии главного меню")
    public Selectors checkingComplianceMainMenu() {
        List<String> elements = Arrays.asList("SberPay", "СберПрайм+", "Кредиты", "Ипотека", "Карты", "Вклады", "Премиум", "Инвестиции", "Платежи", "Переводы", "Переводы", "Страхование", "Поддержка");
        for (String element : elements) {
            page.elementsMenu(element).shouldBe(exist);
        }
        return this;
    }

    @Step("Проверка соответсвия под меню вкладки 'Ипотеки'")
    public Selectors checkingComplianceSubstitutionsMortgage() {
        List<String> elements = Arrays.asList("Все ипотечные кредиты", "Ипотека на вторичное жильё", "Ипотека на новостройки", "Ипотека по двум документам", "Ипотека с господдержкой");
        for (String element : elements) {
            page.subcategoryMortgage(element).shouldBe(exist);
        }
        return this;
    }

}