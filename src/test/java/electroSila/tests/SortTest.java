package electroSila.tests;

import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.StylersPage;
import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SortTest extends BaseTest {
    @Description("Сортировка товаров. Ожидаемый результат: товары располагаются в порядке согласно типу сортировки.")
    @Test
    public void sortProductsTest() {
        MainPage mainPage = new MainPage();
        mainPage.openCatalog();
        mainPage.navigateToItem("Красота и здоровье");
        mainPage.navigateToSubMenuItem("Стайлеры");

        StylersPage stylersPage = new StylersPage();
        stylersPage.areProductsShowed();
        stylersPage.clickOnSort();
        stylersPage.sortProducts("Начать с дешевых");
        stylersPage.showAllProducts();
        stylersPage.areSortProductsShowedGood();
    }
}
