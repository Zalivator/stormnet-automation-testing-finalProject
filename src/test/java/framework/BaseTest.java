package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        driver.get(PropertyReader.getProperty("base.URL"));
        driver.manage().timeouts().implicitlyWait(new PropertyReader("config.properties").getIntProperty("timeout.for.page.load"), TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
