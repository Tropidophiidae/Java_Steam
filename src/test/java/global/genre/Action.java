package global.genre;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import webDriver.DriverInit;

import java.io.File;
import java.io.IOException;

public class Action implements Genre {
    private final String xpathLinkAction = "//div[@id='genre_flyout']//a[contains(.,'%s')]";

    @Override
    public void goToGenre() {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode browser = null;
        try {
            browser = mapper.readTree(new File("src\\test\\resources\\config.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String lng = browser.path("language").asText();
        mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(new File("src\\test\\resources\\Action.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DriverInit.getDriver().findElement(By.xpath(String.format(xpathLinkAction, root.path(lng).asText()))).click();
    }
}
