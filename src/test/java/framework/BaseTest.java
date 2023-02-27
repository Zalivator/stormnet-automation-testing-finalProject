package framework;

import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {
    public static Browser driver = new Browser();

    @BeforeMethod
    public void setup(){
        driver.getInstance();
        driver.windowMaximize();
        driver.navigate(PropertyReader.getProperty("base.URL"));
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown(){
        driver.exit();
    }
}
