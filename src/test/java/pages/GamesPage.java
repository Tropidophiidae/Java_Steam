package pages;

import form.GameForm;
import global.option.Option;
import model.Game;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webDriver.DriverInit;

import java.util.List;

public class GamesPage{
    private final By xpathDiscount = By.xpath("//div[@style=\"display: block;\"]//div[@class='discount_pct']");
    private final GameForm gameForm = new GameForm();

    public void selectOption(Option option) {
        option.selectOption();
    }

    public Game getGameWithMaxDiscount() {
        List<WebElement> gamesWithDiscount = DriverInit.getDriver().findElements(xpathDiscount);
        Assert.assertFalse(gamesWithDiscount.isEmpty(), "There is no game with discount");
        double maxDiscount = 0;
        WebElement gameMaxDiscount = DriverInit.getDriver().findElement(By.xpath("//html"));
        double discount;
        for (WebElement gameDiscount : gamesWithDiscount) {
            discount = Double.parseDouble(gameDiscount.getText().replaceAll("-", "").replaceAll("%", ""));
            if (discount > maxDiscount) {
                maxDiscount = discount;
                gameMaxDiscount = gameDiscount.findElement(By.xpath("..//.."));
            }
        }
        WebElement gameBox = DriverInit.getDriver().findElement(By.xpath(String.format("//a[@href='%s']", gameMaxDiscount.getAttribute("href"))));
        return gameForm.getGameModel(gameBox);
    }

    public void goToGamePage(Game game) {
        DriverInit.getDriver().findElement(By.xpath(String.format("//a[@href='%s']", game.getLink()))).click();
        new AgePage().openGamePageIfAgeSelectorExist();
    }

    public void goToNextPage() {
        int page = Integer.parseInt(DriverInit.getDriver().findElement(By.xpath("//span[@id='TopSellers_links']//span[contains(@class, 'paged_items_paging_pagelink active')]")).getText());
        DriverInit.getDriver().findElement(By.id("TopSellers_btn_next")).click();
        DriverInit.getDriver().findElement(By.xpath(String.format("//span[@id='TopSellers_links']//span[contains(@class, 'paged_items_paging_pagelink active') and contains(text(), '%s')]", page++))).isDisplayed();
    }
}
