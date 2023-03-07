package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SelectedTelevisorPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//div[@class='name_price']//strong");
    private static final Button BUTTON_ADDITIONAL_SERVICES = new Button(By.xpath("//div[@class='tab_usl']/div[@class='tab_toggle']"));
    private static final Button BUTTON_SHOW_GUARANTEE_SERVICE_TEXT = new Button(By.xpath("//div[@class='tab_usl']//p[text()='Показать']"));

    public SelectedTelevisorPage() {
        super(PAGE_LOCATOR, "Selected product page");
    }
    @Step("Закрытие вкладки 'Дополнительные услуги'")
    public void closeAdditionalServices() {
        BUTTON_ADDITIONAL_SERVICES.clickViaJS();
        Assert.assertEquals(BUTTON_SHOW_GUARANTEE_SERVICE_TEXT.getAttribute("style"), "display: none;");
    }
}
