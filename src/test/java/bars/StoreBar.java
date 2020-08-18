package bars;

import global.genre.Genre;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static webDriver.DriverInit.getDriver;

public class StoreBar{
    private final By xpathGamesList = By.xpath("//div[@id='genre_tab']");

    public void goToGenre(Genre genre) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(xpathGamesList)).build().perform();
        genre.goToGenre();
    }

}