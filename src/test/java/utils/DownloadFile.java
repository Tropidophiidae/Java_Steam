package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DownloadFile{

    private String filePath;
    private int pollingTime;
    private int downloadTimeout;
    private int fileSize;

    public DownloadFile(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File("src\\test\\resources\\config.json"));
            String fileName = root.path("fileName").asText();
            String downloadDir = root.path("downloadDir").asText();
            pollingTime = root.path("pollingTime").asInt();
            downloadTimeout = root.path("downloadTimeout").asInt();
            fileSize = root.path("fileSize").asInt();
            filePath = System.getProperty("user.dir").concat(downloadDir).concat(File.separator).concat(fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
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

        for (int i = 1; i <= downloadTimeout*10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(pollingTime);
            } catch (InterruptedException ignored) {
            }
            result = (int) file.length();
            if (file.exists()) break;
        }
        return result;
    }

    public boolean isFileDownloaded(){
        return fileSize==getDownloadedFileSize();
    }
}
