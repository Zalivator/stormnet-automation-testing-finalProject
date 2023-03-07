package framework.elements;

import framework.Browser;
import framework.PropertyReader;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@Log4j2
public abstract class BaseElement {
    protected WebElement element;
    protected List<WebElement> elements;
    private By by;
    private String name;
    private WebDriverWait wait;

    public BaseElement(By by) {
        this.by = by;
    }

    public BaseElement(By by, String name) {
        this.by = by;
        this.name = name;
    }

    public WebElement getElement() {
        isElementPresent();
        return element;
    }

    public List<WebElement> getElements() {
        waitForElementsArePresent();
        return elements;
    }

    public void waitForElementsArePresent() {
        areElementsPresent(Integer.parseInt(Browser.getTimeoutForCondition()));
    }

    protected abstract String getElementType();

    public boolean isElementPresent() {
        try {
            Browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(Browser.getTimeoutForCondition()), TimeUnit.SECONDS);
            element = Browser.getDriver().findElement(by);
            log.info(getElementType() + ": " + by + " - is present");
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            log.info(getElementType() + ": " + by + " - is not present. Exception - NoSuchElementException");
        } catch (Exception e) {
            log.info("Exception: " + e);
        }
        return false;
    }

    public boolean areElementsPresent(int timeout) {
        wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(timeout));
        Browser.getDriver().manage().timeouts().implicitlyWait(Integer.valueOf(Browser.getTimeoutForCondition()), TimeUnit.SECONDS);
        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver driver) {
                    try {
                        elements = driver.findElements(by);
                        for (WebElement element : elements) {
                            if (element instanceof WebElement && element.isDisplayed()) {
                                element = (WebElement) element;
                                return element.isDisplayed();
                            }
                        }
                        element = (WebElement) driver.findElement(by);
                    } catch (Exception e) {
                        return false;
                    }
                    return element.isDisplayed();
                }
            });
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public void sendKeys(String sendKeys) {
        isElementPresent();
        log.info("Send keys: " + getElementType() + ": " + by);
        getElement().sendKeys(sendKeys);
    }

    public boolean isSelected() {
        isElementPresent();
        log.info(getElementType() + ": " + by + " is selected: " + element.isDisplayed());
        return element.isSelected();
    }
    public boolean isDisplayed() {
        isElementPresent();
        log.info(getElementType() + ": " + by + " is displayed: " + element.isDisplayed());
        return element.isDisplayed();
    }

    public String getText() {
        isElementPresent();
        return element.getText();
    }

    public void click() {
        isElementPresent();
        log.info(new PropertyReader("log.properties").getProperty("element.click") + " - " + getElementType() + ": " + by);
        element.click();
    }

    public void clickAndWait() {
        isElementPresent();
        log.info(new PropertyReader("log.properties").getProperty("element.click") + " - " + getElementType() + ": " + by);
        element.click();
        Browser.waitForPageToLoad();
    }

    public void clickViaJS() {
        isElementPresent();
        log.info(new PropertyReader("log.properties").getProperty("element.click") + " - " + getElementType() + ": " + by);
        if (Browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].style.border='3px solid blue'", element);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].click();", element);
        }
    }

    public void moveAndClickByAction() {
        Actions action = new Actions(Browser.getDriver());
        isElementPresent();
        log.info(new PropertyReader("log.properties").getProperty("element.click") + " - " + getElementType() + ": " + by);
        action.moveToElement(element).click().perform();
    }

    public void moveToElement() {
        Actions action = new Actions(Browser.getDriver());
        isElementPresent();
        action.moveToElement(element).perform();
    }

    public void selectComboBox (String value) {
        isElementPresent();
        log.info(new PropertyReader("log.properties").getProperty("element.select") + " - " + getElementType() + ": " + by);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public String getAttribute(String attribute) {
        isElementPresent();
        return element.getAttribute(attribute);
    }

    public void scrollIntoView() {
        isElementPresent();
        if (Browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].style.border='3px solid yellow'", element);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);
        }
    }
}
