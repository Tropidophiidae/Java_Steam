package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static webDriver.Configuration.getConfigValue;
import static webDriver.DriverInit.*;

public class DownloadFile {

    private final String filePath;
    private final int pollingTime;
    private final int timeout;
    private final int fileSize;

    public DownloadFile() {
        String fileName = getConfigValue("fileName");
        getInstance();
        pollingTime = Integer.parseInt(getConfigValue("pollingTime"));
        timeout = Integer.parseInt(getConfigValue("timeout"));
        fileSize = Integer.parseInt(getConfigValue("fileSize"));
        filePath = getBrowser().getBrowserDownloadDirectory().concat(File.separator).concat(fileName);
    }


    public void checkForExistedFile() {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    private int getDownloadedFileSize() {
        int result = 0;
        File file = new File(filePath);

        for (int i = 1; i <= timeout * 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(pollingTime);
            } catch (InterruptedException ignored) {
            }
            result = (int) file.length();
            if (file.exists()) break;
        }
        return result;
    }

    public boolean isFileDownloaded() {
        return fileSize == getDownloadedFileSize();
    }
}
