package electroSila.tests;

import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.SelectedStylerPage;
import electroSila.pageObject.pages.StylersPage;
import electroSila.pageObject.windows.CartWindow;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class DeleteProductTest extends BaseTest {
    @Description("Удаление товара из корзины. Ожидаемый результат: товар не отображается в корзине и кнопка для отображения корзины не отображается.")
    @Test
    public void deleteProductFromTheCart() {
        MainPage mainPage = new MainPage();
        mainPage.openCatalog();
        mainPage.navigateToItem("Красота и здоровье");
        mainPage.navigateToSubMenuItem("Стайлеры");

        StylersPage stylersPage = new StylersPage();
        stylersPage.goToProductPage("ROWENTA SF1012F0");

        SelectedStylerPage selectedStylerPage = new SelectedStylerPage();
        selectedStylerPage.addToCart();

        CartWindow cartWindow = new CartWindow();
        cartWindow.editCountProduct("minus");
    }
}
