package electroSila.pageObject.windows;

import framework.elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CartWindow {
    private static final Button BUTTON_CART = new Button(By.xpath("//div[@class='flypanel']//a[@class='red']"));

    @Step("Уменьшение товара на 1 еденицу")
    public void editCountProduct(String nameEditCountClass) {
        Button editCount = new Button(By.className(nameEditCountClass));
        editCount.click();
    }
    @Step("Проверка на удаление товара из корзины.")
    public void isProductDeleted() {
        Assert.assertFalse(BUTTON_CART.isElementPresent(), "Товары еще есть в корзине");
    }
}
