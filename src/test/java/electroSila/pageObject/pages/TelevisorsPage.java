package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TelevisorsPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//div[@class='breadcrumb']//span[text()='Телевизоры']");
    private static final String PRODUCT_PREV = "//img[@title='%s']/..";
    private static final String BUTTON_FILTERS_VALUE = "//u[text()='%s']";
    private static final String CHECKBOX_FILTER_VALUE = "//strong[text()='%s']/../input";
    private static final Button BUTTON_SHOW_FILTERED_PRODUCTS = new Button(By.id("filter_sbm"));
    private static final TextBox COOKIE_BLOCK = new TextBox(By.xpath("//div[@class='cookies_wrap show']"));
    private static final Button COOKIE_CLOSE_BUTTON = new Button(By.xpath("//button[@class='cookies_save']"));
    private static final Label PRODUCTS_EQUALS_FILTERS = new Label(By.xpath("//div[@class='tov_prew']"));
    private static final TextBox NO_FILTERED_PRODUCTS = new TextBox(By.xpath("//span[text()='Ничего не найдено по вашим критериям']/.."));
    private static final Button BUTTON_SHOW_MORE = new Button(By.xpath("//a[@class='navi_dyn']"));
    private static final String TEXT_PRODUCTS_EQUALS_FILTER = "//b[contains(text(), '%s')]/../i";
    private static final TextBox PRODUCTS_NAME_EQUALS_REQUEST = new TextBox(By.xpath("//div[@class='tov_prew']//strong"));
    private static final String CHECKBOX_PRODUCT_COMPARE = "//img[@title='%s']/../..//input";
    private static final String NAVIGATION_BUTTON_TO_COMPARED_PRODUCTS = "//img[@title='%s']/../../..//a[@class='show_comp']";

    public TelevisorsPage() {
        super(PAGE_LOCATOR, "'Televisors' page");
    }

    @Step("Переход на страницу выбранного товара при нажатии на него.")
    public void navigateToProduct(String productTitle) {
        Label productPrev = new Label(By.xpath(String.format(PRODUCT_PREV, productTitle)));
        productPrev.clickAndWait();
    }
    @Step("Выбор производителя телевизора в фильтрах.")
    public void choiceBrand(String brandFilterId) {
        Input brandCheckbox = new Input(By.id(brandFilterId));
        brandCheckbox.moveAndClickByAction();
    }
    @Step("Раскрытие выпадающего списка в фильтрах.")
    public void openFilterList(String filtersValue) {
        Button buttonFiltersValue = new Button(By.xpath(String.format(BUTTON_FILTERS_VALUE, filtersValue)));
        buttonFiltersValue.scrollIntoView();
        buttonFiltersValue.clickViaJS();
    }
    @Step("Выбор фильтра 'Технология экрана'.")
    public void choiceFilterValue(String filterValue) {
        Input checkboxFilterValue = new Input(By.xpath(String.format(CHECKBOX_FILTER_VALUE, filterValue)));
        checkboxFilterValue.clickViaJS();
    }
    @Step("Показ отфильтрованных товаров.")
    public void showFilteredProducts() {
        BUTTON_SHOW_FILTERED_PRODUCTS.scrollIntoView();
        BUTTON_SHOW_FILTERED_PRODUCTS.clickViaJS();
    }
    @Step("Проверка на совпадение товаров для выбранных фильтров.")
    public void areProductsEqualsFiltersShowed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(NO_FILTERED_PRODUCTS.isElementPresent(), "По выбранным фильтрам ничего не найдено");
        softAssert.assertAll();
    }
    @Step("Отображение всех товаров на одной странице.")
    public void showAllProducts() {
        while (BUTTON_SHOW_MORE.isElementPresent()) {
            BUTTON_SHOW_MORE.scrollIntoView();
            BUTTON_SHOW_MORE.clickViaJS();
        }
    }
    @Step("Проверка характеристик отображаемых товаров согласно выбранных фильтров.")
    public void areShowedProductsFilteredSuccessfully() {
        TextBox screenTechnology = new TextBox(By.xpath(String.format(TEXT_PRODUCTS_EQUALS_FILTER, "Технология экрана")));
        for (int i = 0; i < PRODUCTS_EQUALS_FILTERS.getElements().size(); i++){
            Assert.assertTrue(PRODUCTS_EQUALS_FILTERS.isDisplayed());
            Assert.assertEquals(screenTechnology.getText(), "QLED");
            Assert.assertTrue(PRODUCTS_NAME_EQUALS_REQUEST.getText().contains("SAMSUNG"));
        }
    }
    @Step("Проверка на наличие всплывающего окна с cookie.")
    public void isCookieOpened() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(COOKIE_BLOCK.isElementPresent(), "Cookie отсутствует на странице.");
        softAssert.assertAll();
    }
    @Step("Закрытие pop-up с cookie.")
    public void closeCookies() {
        COOKIE_CLOSE_BUTTON.click();
    }
    @Step("Добавление товара для сравнения.")
    public void addProductToCompare(String productTitle) {
        Input checkboxProductCompare = new Input(By.xpath(String.format(CHECKBOX_PRODUCT_COMPARE, productTitle)));
        checkboxProductCompare.scrollIntoView();
        checkboxProductCompare.clickViaJS();
    }
    @Step("Проверка выбранных для сравнения товаров.")
    public void checkProductsToCompare(String productTitle) {
        Label navigationToComparedProducts = new Label(By.xpath(String.format(NAVIGATION_BUTTON_TO_COMPARED_PRODUCTS, productTitle)));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(navigationToComparedProducts.isElementPresent(), "Было выбрано менее двух товаров для сравнения.");
        softAssert.assertAll();
    }
    @Step("Переход к странице сравнения товаров.")
    public void navigateToComparePage(String productTitle) {
        Label navigationToComparedProducts = new Label(By.xpath(String.format(NAVIGATION_BUTTON_TO_COMPARED_PRODUCTS, productTitle)));
        navigationToComparedProducts.scrollIntoView();
        navigationToComparedProducts.clickAndWait();
    }
}