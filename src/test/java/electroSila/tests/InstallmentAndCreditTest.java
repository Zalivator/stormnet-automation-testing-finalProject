package electroSila.tests;

import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.SelectedTelevisorPage;
import electroSila.pageObject.pages.TelevisorsPage;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class InstallmentAndCreditTest extends BaseTest {
    @Description("Открытие окна 'Справочный расчет при оплате частями' для выбранного продукта. Ожидаемый результат: окно 'Справочный расчет при оплате частями' открывается.")
    @Test
    public void installmentsAndCreditsTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Телевизоры");

        TelevisorsPage televisorsPage = new TelevisorsPage();
        televisorsPage.navigateToProduct("LG 50UQ81006LB телевизор");

        SelectedTelevisorPage selectedTelevisorPage = new SelectedTelevisorPage();
        selectedTelevisorPage.openInstallmentAndCreditWindow();
        selectedTelevisorPage.isCreditWindowOpened();
    }

}
