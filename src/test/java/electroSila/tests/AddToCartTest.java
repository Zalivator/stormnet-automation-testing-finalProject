package electroSila.tests;

import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.SelectedStylerPage;
import electroSila.pageObject.pages.StylersPage;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    @Description("Переход к товару и добавление его в корзину. Ожидаемый результат: товар отображается в корзине.")
    @Test
    public void addProductToCartTest() {
        MainPage mainPage = new MainPage();
        mainPage.openCatalog();
        mainPage.navigateToItem("Красота и здоровье");
        mainPage.navigateToSubMenuItem("Стайлеры");

        StylersPage stylersPage = new StylersPage();
        stylersPage.goToProductPage("ROWENTA SF1012F0");

        SelectedStylerPage selectedStylerPage = new SelectedStylerPage();
        selectedStylerPage.addToCart();
        selectedStylerPage.isCartWindowShowed();
        selectedStylerPage.isProductAddedToCartSuccessfully();
    }
}
