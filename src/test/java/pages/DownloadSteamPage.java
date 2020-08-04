package pages;

import org.openqa.selenium.By;
import webDriver.DriverInit;

public class DownloadSteamPage{
    private final By xpathDownloadSteam = By.className("about_install_steam_link");

    public void downloadSteam() {
        DriverInit.getDriver().findElement(xpathDownloadSteam).click();
    }
}
