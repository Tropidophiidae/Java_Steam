package tests;

import bars.GlobalActionBar;
import org.testng.annotations.Test;
import pages.DownloadSteamPage;
import utils.DownloadFile;

import static asserts.Asserts.isFileDownloaded;
import static logger.log4j2.log;

public class DownloadInstallSteam extends BaseTest {

    @Test
    public void DownloadInstallSteamTest(){
        log().info("Test Case --- " + this.getClass().getSimpleName());
        GlobalActionBar globalBar = new GlobalActionBar();
        DownloadSteamPage downloadSteamPage = new DownloadSteamPage();
        DownloadFile downloadFile = new DownloadFile();

        log().info("Step 1 --- Go to Steam website");
        goToStartPage();
        log().info("Step 2 --- Go to Install Steam page");
        globalBar.goToInstallSteamPage();
        downloadFile.checkForExistedFile();
        log().info("Step 3 --- Click install Steam button");
        downloadSteamPage.downloadSteam();
        log().info("Step 4 --- Check SteamSetup.exe file is downloaded");
        isFileDownloaded();
    }
}
