package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ComparePage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//h1[@class='compare']");
    private static final String PRODUCT_TITLE = "//img[@title='%s']";
    public ComparePage() {
        super(PAGE_LOCATOR, "'Compare' page");
    }

    @Step("Проверка выбранных для сравнения товаров.")
    public void showSelectedProducts(String nameProduct) {
        TextBox productTitle = new TextBox(By.xpath(String.format(PRODUCT_TITLE, nameProduct)));
        Assert.assertTrue(productTitle.isDisplayed(), "Выбранный товар не был добавлен на страницу сравнения!");
    }
}
