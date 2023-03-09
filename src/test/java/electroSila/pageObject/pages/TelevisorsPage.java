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
    private static final Label PRODUCTS_EQUALS_FILTERS = new Label(By.xpath("//div[@class='tov_prew']"));
    private static final TextBox NO_FILTERED_PRODUCTS = new TextBox(By.xpath("//span[text()='Ничего не найдено по вашим критериям']/.."));
    private static final Button BUTTON_SHOW_MORE = new Button(By.xpath("//a[@class='navi_dyn']"));
    private static final String TEXT_PRODUCTS_EQUALS_FILTER = "//b[contains(text(), '%s')]/../i";
    private static final TextBox PRODUCTS_NAME_EQUALS_REQUEST = new TextBox(By.xpath("//div[@class='tov_prew']//strong"));

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

    @Step("Демонстрация примененных фильтров.")
    public void showFilteredProducts() {
        BUTTON_SHOW_FILTERED_PRODUCTS.scrollIntoView();
        BUTTON_SHOW_FILTERED_PRODUCTS.clickViaJS();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(NO_FILTERED_PRODUCTS.isElementPresent(), "По выбранным фильтрам ничего не найдено");
        while (BUTTON_SHOW_MORE.isElementPresent()) {
            BUTTON_SHOW_MORE.scrollIntoView();
            BUTTON_SHOW_MORE.clickViaJS();
        }
        TextBox screenTechnology = new TextBox(By.xpath(String.format(TEXT_PRODUCTS_EQUALS_FILTER, "Технология экрана")));
        for (int i = 0; i < PRODUCTS_EQUALS_FILTERS.getElements().size(); i++){
            Assert.assertTrue(PRODUCTS_EQUALS_FILTERS.isDisplayed());
            Assert.assertEquals(screenTechnology.getText(), "QLED");
            Assert.assertTrue(PRODUCTS_NAME_EQUALS_REQUEST.getText().contains("SAMSUNG"));
        }
        softAssert.assertAll();
    }
}
