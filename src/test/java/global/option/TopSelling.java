package global.option;

import org.openqa.selenium.By;
import webDriver.DriverInit;

public class TopSelling implements Option {
    private final By xpathTopSellers = By.xpath("//div[@id='tab_select_TopSellers']");

    @Override
    public void selectOption() {
        DriverInit.getDriver().findElement(xpathTopSellers).click();
    }
}
