package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//div[@class='top']//img[@class='logo_sila']");
    private static final String HEADER_MENU_ITEM = "//div[@class='header_menu__item']/a[text()='%s']";
    public MainPage() {
        super(PAGE_LOCATOR, "'Main' Page");
    }
    @Step("Переход на страницу из навигационного меню на главной страницы.")
    public void navigateHeaderMenu(String menuItem) {
        Label headerMenuItem = new Label(By.xpath(String.format(HEADER_MENU_ITEM, menuItem)));
        headerMenuItem.clickAndWait();
    }
}
