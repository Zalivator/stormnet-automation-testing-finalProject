package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TelevisorsPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//div[@class='breadcrumb']//span[text()='Телевизоры']");
    private static final String PRODUCT_PREV = "//img[@title='%s']/..";
    private static final Button BUTTON_ADDITIONAL_SERVICES = new Button(By.xpath("//div[@class='tab_usl']/div[@class='tab_toggle']"));
    private static final Button BUTTON_PRODUCTS_RECOMMENDATION = new Button(By.xpath("//div[@class='tab_soputka']/div[@class='tab_toggle']"));
    private static final Button BUTTON_SHOW_GUARANTEE_SERVICE_TEXT = new Button(By.xpath("//div[@class='tab_usl']//p[text()='Показать']"));

    public TelevisorsPage() {
        super(PAGE_LOCATOR, "'Televisors' page");
    }

    @Step("Переход на страницу выбранного товара при нажатии на него.")
    public void navigateToProduct(String productTitle) {
        Label productPrev = new Label(By.xpath(String.format(PRODUCT_PREV, productTitle)));
        productPrev.clickViaJS();
    }
}
