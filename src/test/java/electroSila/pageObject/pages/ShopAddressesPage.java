package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ShopAddressesPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//h1[text()='Адреса магазинов «ЭЛЕКТРОСИЛА»']");
    private static final String SHOW_SHOP_ADDRESS = "//strong[@id='%s']/..//u";
    private static final String ENABLE_MAP = "//strong[@id='%s']/..//ymaps[@class='ymaps-2-1-79-map']";
    public ShopAddressesPage() {
        super(PAGE_LOCATOR, "'Shop addresses' page");
    }

    @Step("Раскрытие карты проезда.")
    public void goToRoadMap(String shopAddressId) {
        Button showShopAddress = new Button(By.xpath(String.format(SHOW_SHOP_ADDRESS, shopAddressId)));
        showShopAddress.scrollIntoView();
        showShopAddress.clickViaJS();
    }
    @Step ("Проверка открытия карты для выбранного магазина.")
    public void isRoadMapOpened(String shopAddressId) {
        TextBox enableMap = new TextBox(By.xpath(String.format(ENABLE_MAP, shopAddressId)));
        Assert.assertTrue(enableMap.isDisplayed(), "Карта для выбранного магазина не была открыта!");
    }
}
