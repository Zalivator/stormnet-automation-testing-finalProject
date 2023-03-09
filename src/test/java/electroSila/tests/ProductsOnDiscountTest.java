package electroSila.tests;

import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.StylersPage;
import electroSila.pageObject.pages.TelevisorsPage;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ProductsOnDiscountTest extends BaseTest {
    @Description("Проверка товаров на скидках. Ожидаемый результат: отображаются только товары на скидках.")
    @Test
    public void discountsTest() {
        MainPage mainPage = new MainPage();
        mainPage.openCatalog();
        mainPage.navigateToItem("Красота и здоровье");
        mainPage.navigateToSubMenuItem("Стайлеры");

        StylersPage stylersPage = new StylersPage();
        stylersPage.showProductsWithDiscountsAndInstallments("btn6");
    }
}
