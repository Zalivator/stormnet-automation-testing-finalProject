package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SelectedStylerPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//div[@class='name_price']//strong");
    private static final Button BUTTON_ADD_TO_CART = new Button(By.xpath("//div[@class='btn_zak']"));
    private static final TextBox CART_LOCATOR = new TextBox(By.xpath("//div[@class='popup_close']"));
    private static final TextBox CART_NAME_PRODUCT = new TextBox(By.xpath("//div[@class='popup_korz_main']//div[@class='name']/span"));
    public SelectedStylerPage() {
        super(PAGE_LOCATOR, "Selected styler page");
    }

    @Step("Добавление товара в корзину")
    public void addToCart() {
        BUTTON_ADD_TO_CART.click();
    }
    @Step("Проверка открытия окна сразу после успешного добавления товара в корзину.")
    public void isCartWindowShowed() {
        Assert.assertTrue(CART_LOCATOR.isDisplayed(), "Товар не был добавлен в корзину. Окно с товарами в корзине не открылось.");
    }
    @Step("Проверка корректного добавления выбранного товара в корзину.")
    public void isProductAddedToCartSuccessfully() {
        TextBox pageLocator = new TextBox(PAGE_LOCATOR);
        Assert.assertTrue(CART_NAME_PRODUCT.getText().contains(pageLocator.getText()), "В каталог был добавлен товар, отличный от того, что был выбран.");
    }
}
