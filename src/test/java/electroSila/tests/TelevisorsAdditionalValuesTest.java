package electroSila.tests;

import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.SelectedTelevisorPage;
import electroSila.pageObject.pages.TelevisorsPage;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TelevisorsAdditionalValuesTest extends BaseTest {
    @Description("Закрытие вкладки 'С этим товаром рекомендуют' на странице с выбранным телевизором. Ожидаемый результат: Вкладка закрывается.")
    @Test
    public void electrosilaTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Телевизоры");

        TelevisorsPage televisorsPage = new TelevisorsPage();
        televisorsPage.navigateToProduct("LG 50UQ81006LB телевизор");

        SelectedTelevisorPage selectedTelevisorPage = new SelectedTelevisorPage();
        selectedTelevisorPage.closeAdditionalServices("tab_soputka");
    }

}
