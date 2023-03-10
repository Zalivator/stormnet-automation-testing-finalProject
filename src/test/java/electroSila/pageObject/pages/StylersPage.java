package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class StylersPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//h1[text()='Плойки и стайлеры для волос']");
    private static final String PRODUCT_LOCATOR = "//strong[text()='%s']/../..";
    private static final Label PRODUCTS_EQUALS_FILTERS = new Label(By.xpath("//div[@class='tov_prew']"));
    private static final Button BUTTON_SHOW_MORE = new Button(By.xpath("//a[@class='navi_dyn']"));
    private static final TextBox PRODUCTS_SALE_PRICE = new TextBox(By.xpath("//div[@class='price']//s"));
    private static final Button PRODUCTS_SORT = new Button(By.xpath("//div[@class='sorted_btns_select']"));
    private static final String TYPE_OF_SORT_PRODUCTS = "//div[@id='sorted_select']/strong[text()='%s']";
    private static final TextBox PRICE_PRODUCT = new TextBox(By.xpath("//div[@class='tov_prew']//div[@class='price']/div/b[1]"));

    public StylersPage() {
        super(PAGE_LOCATOR, "'Stylers' page");
    }

    @Step ("Переход на страницу выбранного товара.")
    public void goToProductPage(String productName) {
        Label productLocator = new Label(By.xpath(String.format(PRODUCT_LOCATOR, productName)));
        productLocator.clickAndWait();
    }

    @Step("Поиск плоек и стайлеров на скидках.")
    public void showProductsWithDiscountsAndInstallments(String nameButton) {
        Button discountButton = new Button(By.className(nameButton));
        discountButton.clickAndWait();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(PRODUCTS_EQUALS_FILTERS.isDisplayed(), "Товары на скидках отсутствуют.");
        while (BUTTON_SHOW_MORE.isElementPresent()) {
            BUTTON_SHOW_MORE.scrollIntoView();
            BUTTON_SHOW_MORE.clickViaJS();
        }
        for (int i = 0; i < PRODUCTS_EQUALS_FILTERS.getElements().size(); i++) {
            Assert.assertTrue(PRODUCTS_EQUALS_FILTERS.isDisplayed());
            Assert.assertTrue(PRODUCTS_SALE_PRICE.isDisplayed(), "Отобразился товар без скидки.");
        }
        softAssert.assertAll();
    }

    @Step("Сортировка товаров по цене 'Начать с дешевых'.")
    public void sortProducts(String sortType) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(PRODUCTS_EQUALS_FILTERS.isDisplayed(), "Отсутствуют товары выбранной категории!");
        PRODUCTS_SORT.click();
        Button typeOfSortProducts = new Button(By.xpath(String.format(TYPE_OF_SORT_PRODUCTS, sortType)));
        typeOfSortProducts.moveAndClickByAction();
        while (BUTTON_SHOW_MORE.isElementPresent()) {
            BUTTON_SHOW_MORE.scrollIntoView();
            BUTTON_SHOW_MORE.clickViaJS();
        }
        for (int i = 0; i < PRICE_PRODUCT.getElements().size(); i++) {
            if (i + 1 == PRICE_PRODUCT.getElements().size()) {
                Assert.assertTrue(compareValuesMore(Integer.parseInt(PRICE_PRODUCT.getElements().get(i).getText()), Integer.parseInt(PRICE_PRODUCT.getElements().get(i-1).getText())), "Сортировка по выбранному типу работает некорректно!");
                break;
            }
            Assert.assertTrue(compareValuesLess(Integer.parseInt(PRICE_PRODUCT.getElements().get(i).getText()), Integer.parseInt(PRICE_PRODUCT.getElements().get(i+1).getText())), "Сортировка по выбранному типу работает некорректно!");
        }
        softAssert.assertAll();
    }
    private boolean compareValuesLess(int a, int b) {
        return a <= b;
    }
    private boolean compareValuesMore(int a, int b) {
        return a >= b;
    }
}
