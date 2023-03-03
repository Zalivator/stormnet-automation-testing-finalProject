package fiveElement.pageObject.windows;

import framework.elements.Button;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class AuthorizationWindow {
    @DataProvider (name = "Correct data")
    public Object[][] dpCorrectDataMethod() {
        return new Object[][] {
                {"", ""}
        };
    }
    private static final String BUTTON_REGISTRATION = "//a[text()='%s']";

    public void goToRegistrationWindow() {
        Button buttonRegistration = new Button(By.xpath(String.format(BUTTON_REGISTRATION, "Зарегистрируйтесь")));
        buttonRegistration.moveAndClickByAction();
    }
}
