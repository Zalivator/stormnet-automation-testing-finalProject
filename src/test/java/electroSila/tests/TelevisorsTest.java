package electroSila.tests;

import electroSila.pageObject.pages.MainPage;
import electroSila.pageObject.pages.SelectedTelevisorPage;
import electroSila.pageObject.pages.TelevisorsPage;
import framework.BaseTest;
import org.testng.annotations.Test;

public class TelevisorsTest extends BaseTest {
    @Test
    public void electrosilaTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Телевизоры");

        TelevisorsPage televisorsPage = new TelevisorsPage();
        televisorsPage.navigateToProduct("LG 50UQ81006LB телевизор");

        SelectedTelevisorPage selectedTelevisorPage = new SelectedTelevisorPage();
        selectedTelevisorPage.closeAdditionalServices();
    }

}
