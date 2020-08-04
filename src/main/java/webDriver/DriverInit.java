package webDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class DriverInit {
    private static DriverInit instance;
    private static WebDriver driver;

    public DriverInit() {
        //TODO: Add logger
        //TODO: Create class for getting configs for browsers
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(new File("src\\test\\resources\\config.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String browser = root.path("browser").asText().toLowerCase();
        if (browser.equals("chrome")) {
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default_directory", System.getProperty("user.dir") + root.path("downloadDir").asText());
            prefs.put("intl.accept_languages", root.path("language").asText());
            prefs.put("download.prompt_for_download", "false");
            prefs.put("safebrowsing.enabled", "true");

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        if (browser.equals("firefox")) {
            FirefoxProfile fxProfile = new FirefoxProfile();
            fxProfile.setPreference("intl.accept_languages", root.path("language").asText());
            fxProfile.setPreference("browser.download.folderList", 2);
            fxProfile.setPreference("browser.download.dir", System.getProperty("user.dir") + root.path("downloadDir").asText());
            fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream, application/x-debian-package, application/x-www-form-urlencod, application/json, application/x-compressed, application/x-zip-compressed, application/zip, multipart/x-zip, text/plain, text/csv");

            FirefoxOptions options = new FirefoxOptions().setProfile(fxProfile);
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(root.path("implicitlyWait").asInt(), TimeUnit.SECONDS);
    }

    public static DriverInit getInstance() {
        if (instance == null) {
            instance = new DriverInit();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        if (driver == null){
            new DriverInit();
        }
        return driver;
    }

    public static void quit() {
        DriverInit.getDriver().quit();
        instance = null;
    }

}