package electroSila.tests;

import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.ShopAddressesPage;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ShowRoadMapTest extends BaseTest {
    @Description("Раскрытие карты проезда на странице с адресами магазинов.")
    @Test
    public void roadMapTest() {
        MainPage mainPage = new MainPage();
        mainPage.goToShopAddresses();

        ShopAddressesPage shopAddressesPage = new ShopAddressesPage();
        shopAddressesPage.goToRoadMap("mag246");
        shopAddressesPage.isRoadMapOpened("mag246");
    }
}
