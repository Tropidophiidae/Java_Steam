package global.genre;

import org.openqa.selenium.By;

import static webDriver.DriverInit.getDriver;
import static webDriver.DriverInit.getBrowser;

public class Action extends Genre {
    private final String xpathLinkAction = "//div[@id='genre_flyout']//a[contains(.,'%s')]";

    @Override
    public void goToGenre() {
        getDriver().findElement(By.xpath(String.format(xpathLinkAction, getActionName(getBrowser().getBrowserLanguage())))).click();
    }
}
