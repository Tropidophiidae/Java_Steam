package tests;

import org.testng.annotations.*;

import static webDriver.Configuration.getConfigValue;
import static webDriver.DriverInit.*;

public class BaseTest {

    public void goToStartPage(){
        getDriver().get(getConfigValue("startUrl"));
    }

    @BeforeMethod
    public void setupTest() {
        getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void endTest() {
        teardown();
    }
}
