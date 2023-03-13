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

public class AfterSearchPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//h1[@class='search']");
    private static final Input INPUT_FIND_PRODUCT = new Input(By.xpath("//div[@class='t_menu1']/..//input[@name='find']"));
    private static final TextBox SEARCH_TEXT_AFTER_REQUEST = new TextBox(By.xpath("//h1[@class='search']"));
    private static final Label PRODUCTS_EQUALS_REQUEST = new Label(By.xpath("//div[@class='tov_prew_search']"));
    private static final TextBox PRODUCTS_NAME_EQUALS_REQUEST = new TextBox(By.xpath("//div[@class='tov_prew_search']//strong"));
    private static final Button BUTTON_SHOW_MORE = new Button(By.xpath("//a[@class='navi_dyn']"));

    public AfterSearchPage() {
        super(PAGE_LOCATOR, "Page after search");
    }

    @Step("Проверка на совпадение запроса при поиске товаров")
    public void equalsRequest() {
        Assert.assertTrue(SEARCH_TEXT_AFTER_REQUEST.isDisplayed(), "Страница поиска товаров не была загружена");
    }
    @Step("Проверка отображения товаров для введенного значения в строку поиска.")
    public void areSearchableProductsShowed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(PRODUCTS_EQUALS_REQUEST.isElementPresent(), "По запросу ничего не найдено");
        softAssert.assertAll();
    }
    @Step("Отображение всех товаров на одной странице.")
    public void showAllProducts() {
        while (BUTTON_SHOW_MORE.isElementPresent()) {
            BUTTON_SHOW_MORE.scrollIntoView();
            BUTTON_SHOW_MORE.clickViaJS();
        }
    }
    @Step("Проверка товаров на совпадение из строки запроса")
    public void productsEqualsRequest() {
        for (int i = 0; i < PRODUCTS_NAME_EQUALS_REQUEST.getElements().size(); i++){
            Assert.assertTrue(PRODUCTS_NAME_EQUALS_REQUEST.getText().contains(INPUT_FIND_PRODUCT.getAttribute("value").toUpperCase()));
        }
    }
}
