package tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.*;
import webDriver.DriverInit;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    String url = "";

    @BeforeMethod
    public void setupTest(){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(new File("src\\test\\resources\\config.json"));
            url = root.path("startUrl").asText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DriverInit.getInstance().getDriver().get(url);
        DriverInit.getInstance().getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        if (DriverInit.getInstance() != null) {
            DriverInit.getInstance().quit();
        }
    }
}
