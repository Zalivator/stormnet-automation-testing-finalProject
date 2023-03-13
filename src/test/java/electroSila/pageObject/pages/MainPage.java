package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//div[@class='top']//img[@class='logo_sila']");
    private static final String HEADER_MENU_ITEM = "//div[@class='header_menu__item']/a[text()='%s']";
    private static final Input INPUT_FIND_PRODUCT = new Input(By.xpath("//div[@class='t_menu1']/..//input[@name='find']"));
    private static final Button BUTTON_FOR_FIND_PRODUCTS = new Button(By.xpath("//div[@class='t_menu1']/..//input[@value='Найти']"));
    private static final Button BUTTON_CATALOG = new Button(By.xpath("//div[@class='t_menu1']/..//span[@class='top_transp__btn']"));
    private static final String CATALOG_ITEM = "//a[text()='%s']";
    private static final Label SHOP_ADDRESSES = new Label(By.className("shops"));

    public MainPage() {
        super(PAGE_LOCATOR, "'Main' Page");
    }
    @Step("Переход на страницу из навигационного меню на главной страницы.")
    public void navigateHeaderMenu(String menuItem) {
        Label headerMenuItem = new Label(By.xpath(String.format(HEADER_MENU_ITEM, menuItem)));
        headerMenuItem.clickAndWait();
    }
    @Step("Ввод нименования в поисковую строку на главной странице")
    public void searchProduct(String productForFind) {
        INPUT_FIND_PRODUCT.sendKeys(productForFind);
    }
    @Step("Переход к странице с найденными товарами")
    public void navigateToFoundProducts() {
        BUTTON_FOR_FIND_PRODUCTS.clickAndWait();
    }
    @Step("Открытие навигационного меню 'Каталог'")
    public void openCatalog() {
        BUTTON_CATALOG.click();
    }
    @Step("Переход к подменю 'Красота и здоровье'")
    public void navigateToItem(String itemName) {
        Label catalogItem = new Label(By.xpath(String.format(CATALOG_ITEM, itemName)));
        catalogItem.moveToElement();
    }
    @Step("Переход на страницу 'Стайлеры'")
    public void navigateToSubMenuItem(String menuItemName) {
        Label subMenuItemName = new Label(By.xpath(String.format(CATALOG_ITEM, menuItemName)));
        subMenuItemName.clickViaJS();
    }
    @Step("Переход на страницу 'Адреса магазинов'.")
    public void goToShopAddresses() {
        SHOP_ADDRESSES.clickAndWait();
    }
}
