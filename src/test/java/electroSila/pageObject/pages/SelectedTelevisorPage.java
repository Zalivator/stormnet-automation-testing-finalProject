package electroSila.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SelectedTelevisorPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//div[@class='name_price']//strong");
    private static final String BUTTON_ADDITIONAL_RECOMMENDATIONS = "//div[@class='%s']/div[@class='tab_toggle']";
    private static final String BUTTON_SHOW_RECOMMENDATIONS = "//div[@class='%s']//p[text()='Показать']";

    public SelectedTelevisorPage() {
        super(PAGE_LOCATOR, "Selected televisor page");
    }
    @Step("Закрытие вкладок 'Дополнительные услуги' и 'С этим товаром рекомендуют'")
    public void closeAdditionalServices(String additionalRecommendationClass) {
        Button buttonAdditionalRecommendations = new Button(By.xpath(String.format(BUTTON_ADDITIONAL_RECOMMENDATIONS, additionalRecommendationClass)));
        buttonAdditionalRecommendations.clickViaJS();
        Button buttonShowRecommendations = new Button(By.xpath(String.format(BUTTON_SHOW_RECOMMENDATIONS, additionalRecommendationClass)));
        Assert.assertEquals(buttonShowRecommendations.getAttribute("style"), "display: none;");
    }
}
