package form;

import model.Game;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GameForm{
    private final String xpathName = ".//div[@class='tab_item_name']";
    private final String xpathDiscount = ".//div[@class='discount_pct']";
    private final String xpathPrice = ".//div[@class='discount_final_price']";

    public Game getGameModel(WebElement textBox) {
        return new Game(getNameFromGameForm(textBox),
                isDiscountExist(textBox) ? getDiscountFromGameForm(textBox) : 0,
                getPriceFromGameForm(textBox),
                getGameLink(textBox));
    }

    private String getNameFromGameForm(WebElement webElement) {
        WebElement nameBox = webElement.findElement(By.xpath(xpathName));
        return nameBox.getText();
    }

    private Double getPriceFromGameForm(WebElement webElement) {
        WebElement priceBox = webElement.findElement(By.xpath(xpathPrice));
        String text = priceBox.getText().replaceAll("\\$", "").replaceAll("[a-zA-Zа-яА-Я]", "");
        if (text.isEmpty()) return 0.0;
        else return Double.parseDouble(text);
    }

    private Double getDiscountFromGameForm(WebElement webElement) {
        WebElement discountBox = webElement.findElement(By.xpath(xpathDiscount));
        String text = discountBox.getText().replaceAll("-", "").replaceAll("%", "");
        return Double.parseDouble(text);
    }

    private boolean isDiscountExist(WebElement webElement) {
        return webElement.findElements(By.xpath(xpathDiscount)).size() > 0;
    }

    private String getGameLink(WebElement webElement) {
        return webElement.getAttribute("href");
    }
}