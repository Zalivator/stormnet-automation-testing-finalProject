package electroSila.tests;

import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.StylersPage;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class NavigationCatalogTest extends BaseTest {
    @Description("Навигация по меню 'Каталог'. Ожидаемый результат: переход к странице, в соответствии с выбранным значением.")
    @Test
    public void navigationTest() {
        MainPage mainPage = new MainPage();
        mainPage.openCatalog();
        mainPage.navigateToItem("Красота и здоровье");
        mainPage.navigateToSubMenuItem("Стайлеры");

        StylersPage stylersPage = new StylersPage();
    }
}
