package tests;

import org.testng.annotations.*;

import static webDriver.Configuration.getConfigValue;
import static webDriver.DriverInit.*;

public class BaseTest {

    @BeforeMethod
    public void setupTest() {
        getDriver().get(getConfigValue("startUrl"));
        getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void endTest() {
        teardown();
    }
}
