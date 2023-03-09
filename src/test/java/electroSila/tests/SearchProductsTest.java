package electroSila.tests;

import electroSila.pageObject.pages.AfterSearchPage;
import electroSila.pageObject.pages.MainPage;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SearchProductsTest extends BaseTest {
    @Description("Поиск товаров в каталоге. Ожидаемый результат: отображение товаров, название которых включает в себя значение в поисковой строке.")
    @Test
    public void searchTest() {
        MainPage mainPage = new MainPage();
        mainPage.searchProduct("LG");
        mainPage.navigateToFoundProducts();

        AfterSearchPage afterSearchPage = new AfterSearchPage();
        afterSearchPage.equalsRequest();
        afterSearchPage.productsEqualsRequest();
    }
}
