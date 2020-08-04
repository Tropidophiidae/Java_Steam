package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import webDriver.DriverInit;

public class AgePage{
    private static final String AGE = "1990";
    private final By xpathViewPageWithSelector = By.xpath("//a[@onclick='ViewProductPage()']");
    private final By xpathViewPageWithoutSelector = By.xpath("//a[contains(@class, 'btn_grey') and contains(@href, '#')]");
    private final By xpathYearSelect = By.xpath("//select[@name='ageYear']");

    public void openGamePageIfAgeSelectorExist() {
        if (DriverInit.getDriver().findElements(xpathViewPageWithSelector).size() > 0) {
            new Select(DriverInit.getDriver().findElement((xpathYearSelect))).selectByValue(AGE);
            DriverInit.getDriver().findElement(xpathViewPageWithSelector).click();
        } else if (DriverInit.getDriver().findElements(xpathViewPageWithoutSelector).size() > 0) {
            DriverInit.getDriver().findElement(xpathViewPageWithoutSelector).click();
        }
    }
}
