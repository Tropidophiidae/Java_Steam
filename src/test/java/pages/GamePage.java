package pages;

import model.Game;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.DriverInit;

public class GamePage{
    private final By xpathGameName = By.xpath("//div[@class='apphub_AppName']");
    private final By xpathGamePrice = By.xpath("//div[@class='game_area_purchase_game']//div[@class='discount_final_price']");
    private final By xpathGameDiscount = By.xpath("//div[@class='game_area_purchase_game']//div[@class='discount_pct']");

    public Game getGameModel() {
        return new Game(getGameName(),
                getGameDiscount(),
                getGamePrice(),
                getGameLink());
    }

    private String getGameName() {
        return DriverInit.getDriver().findElement(xpathGameName).getText();
    }

    private double getGamePrice() {
        WebElement priceBox = DriverInit.getDriver().findElement(xpathGamePrice);
        String text = priceBox.getText().replaceAll("\\$", "").replaceAll("[a-zA-Zа-яА-Я]", "");
        return Double.parseDouble(text);
    }

    private double getGameDiscount() {
        WebElement discountBox = DriverInit.getDriver().findElement(xpathGameDiscount);
        String text = discountBox.getText().replaceAll("-", "").replaceAll("%", "");
        return Double.parseDouble(text);
    }

    private String getGameLink() {
        return DriverInit.getDriver().getCurrentUrl();
    }
}
