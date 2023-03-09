package electroSila.tests;

import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.TelevisorsPage;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class FiltrationProductsTest extends BaseTest {
    @Description("Фильтрация товаров. Ожидаемый результат: отображение товаров, содержащих значения выбранных фильтров.")
    @Test
    public void filtrationTelevisorsTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Телевизоры");

        TelevisorsPage televisorsPage = new TelevisorsPage();
        televisorsPage.choiceBrand("idsortSAMSUNG");
        televisorsPage.openFilterList("Технология экрана");
        televisorsPage.choiceFilterValue("QLED");
        televisorsPage.showFilteredProducts();
    }
}
