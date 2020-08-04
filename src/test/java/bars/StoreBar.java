package bars;

import global.genre.Genre;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import webDriver.DriverInit;

public class StoreBar{
    private final By xpathGamesList = By.xpath("//div[@id='genre_tab']");

    public void goToGenre(Genre genre) {
        Actions actions = new Actions(DriverInit.getDriver());
        actions.moveToElement(DriverInit.getDriver().findElement(xpathGamesList)).build().perform();
        genre.goToGenre();
    }

}