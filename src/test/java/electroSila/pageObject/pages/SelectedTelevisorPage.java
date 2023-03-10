package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SelectedTelevisorPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//div[@class='name_price']//strong");
    private static final Button BUTTON_INSTALLMENT_AND_CREDIT = new Button(By.xpath("//span[@class='btn_kredit_calc']"));
    private static final TextBox WINDOW_LOCATOR = new TextBox(By.xpath("//div[@class='popup_kredit']"));

    public SelectedTelevisorPage() {
        super(PAGE_LOCATOR, "Selected televisor page");
    }
    @Step("Открытие окна с рассчетом кредита и рассрочки.")
    public void openInstallmentAndCreditWindow() {
        BUTTON_INSTALLMENT_AND_CREDIT.click();
        Assert.assertTrue(WINDOW_LOCATOR.isElementPresent(), "Окно с рассчетом кредита и рассрочки не открылось!");
    }
}
