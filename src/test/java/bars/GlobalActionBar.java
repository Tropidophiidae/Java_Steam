package bars;

import org.openqa.selenium.By;
import webDriver.DriverInit;

public class GlobalActionBar{
    private final By xpathInstallSteam = By.xpath("//div[contains(@class, 'header_installsteam')]");

    public void goToInstallSteamPage() {
        DriverInit.getDriver().findElement(xpathInstallSteam).click();
    }
}