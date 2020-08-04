package tests;

import bars.GlobalActionBar;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DownloadSteamPage;
import utils.DownloadFile;

public class DownloadInstallSteam extends BaseTest {

    @Test
    public void DownloadInstallSteamTest(){
        GlobalActionBar globalBar = new GlobalActionBar();
        DownloadSteamPage downloadSteamPage = new DownloadSteamPage();
        DownloadFile downloadFile = new DownloadFile();

        globalBar.goToInstallSteamPage();
        downloadFile.checkForExistedFile();
        downloadSteamPage.downloadSteam();
        Assert.assertTrue(downloadFile.isFileDownloaded());
    }
}
