package fiveElement.tests;

import fiveElement.pageObject.windows.AuthorizationWindow;
import framework.BaseTest;
import org.testng.annotations.Test;

public class Registration extends BaseTest {
    @Test
    public void registrationTest() {
        AuthorizationWindow authorizationWindow = new AuthorizationWindow();
        authorizationWindow.goToRegistrationWindow();
    }
}
