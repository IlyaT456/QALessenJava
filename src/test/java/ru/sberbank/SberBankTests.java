package ru.sberbank;

import config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Selectors;

public class SberBankTests extends BaseTest {
    Selectors selector = new Selectors();

    @Test
    @DisplayName("Проверка работы кнопки заявки 'Ипотека на новостройки'")
    public void sberBankMortgagTest() {
        selector.openMainPage()
                .categoryPanel("Ипотека")
                .subcategoryMortgage("Ипотека на новостройки")
                .cheakButtonApplication();
    }

    @Test
    @DisplayName("Проверка перехода на страницу 'Оплата услуг ЖКХ'")
    public void sberBankPaymentServices() {
        selector.openMainPage()
                .categoryPanel("Платежи")
                .paymentServicesCategory()
                .searchTab("ЖКХ")
                .cheakText("Оплата услуг ЖКХ");
    }

    @Test
    @DisplayName("Проверка ошибок консоли")
    public void consoleShouldNotHaveErrorsTest() {
        selector.openMainPage()
                .consoleShouldNotHaveErrorsTest();
    }

    @Test
    @DisplayName("Проверка соответсвии главного меню")
    public void сheckComplianceMainMenu() {
        selector.openMainPage()
                .checkingComplianceMainMenu();
    }

    @Test
    @DisplayName("Проверка соответсвия под меню вкладки 'Ипотеки'")
    public void сheckComplianceSubstitutions() {
        selector.openMainPage()
                .categoryPanel("Ипотека")
                .checkingComplianceSubstitutionsMortgage();
    }
}
