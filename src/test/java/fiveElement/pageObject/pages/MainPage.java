package fiveElement.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static final String BUTTON_SIGN_IN = "//div[text()='Вход']/../..//span/../..";

    public MainPage() {
        super(BUTTON_SIGN_IN, "'Main' Page");
    }
    public void navigateHeaderMenu() {
        Button buttonSignIn = new Button(By.xpath(BUTTON_SIGN_IN));
        buttonSignIn.click();
    }
}
