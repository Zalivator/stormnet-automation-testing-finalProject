package fiveElement.tests;

import fiveElement.pageObject.pages.MainPage;
import framework.BaseTest;
import org.testng.annotations.Test;

public class Authorization extends BaseTest {

    @Test
    public void authorizationTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu();
    }



}
