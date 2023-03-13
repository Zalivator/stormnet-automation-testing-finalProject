package electroSila.tests;

import electroSila.pageObject.pages.ComparePage;
import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.TelevisorsPage;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CompareTest extends BaseTest {
    @Description("Сравнение выбранных товаров. Ожидаемый результат: выбранные товары и их характеристики отображаются на отдельной странице.")
    @Test
    public void
    compareProductsTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Телевизоры");

        TelevisorsPage televisorsPage = new TelevisorsPage();
        televisorsPage.isCookieOpened();
        televisorsPage.closeCookies();
        televisorsPage.addProductToCompare("LG 50UQ81006LB телевизор");
        televisorsPage.addProductToCompare("LG 43UQ75006LF телевизор");
        televisorsPage.checkProductsToCompare("LG 50UQ81006LB телевизор");
        televisorsPage.checkProductsToCompare("LG 43UQ75006LF телевизор");
        televisorsPage.navigateToComparePage("LG 43UQ75006LF телевизор");

        ComparePage comparePage = new ComparePage();
        comparePage.showSelectedProducts("LG 50UQ81006LB телевизор");
        comparePage.showSelectedProducts("LG 43UQ75006LF телевизор");
    }
}
