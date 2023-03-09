package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ShopAddressesPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//h1[text()='Адреса магазинов «ЭЛЕКТРОСИЛА»']");
    private static final String SHOW_SHOP_ADDRESS = "//strong[@id='']/..//u";
    public ShopAddressesPage() {
        super(PAGE_LOCATOR, "'Shop addresses' page");
    }

    @Step("Раскрытие карты проезда.")
    public void goToRoadMap(String shopAddressId) {
        Button showShopAddress = new Button(By.xpath(String.format(SHOW_SHOP_ADDRESS, shopAddressId)));
        showShopAddress.moveAndClickByAction();
    }
}
