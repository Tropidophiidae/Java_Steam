package tests;

import bars.StoreBar;
import global.genre.Action;
import global.option.TopSelling;
import model.Game;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GamePage;
import pages.GamesPage;

public class GameWithMaxDiscount extends BaseTest {

    @Test
    public void GameWithMaxDiscountTest(){
        StoreBar storeBar = new StoreBar();
        GamesPage gamesPage = new GamesPage();
        GamePage gamePage = new GamePage();

        storeBar.goToGenre(new Action());
        gamesPage.selectOption(new TopSelling());
        Game gameFromGamesPage = gamesPage.getGameWithMaxDiscount();
        gamesPage.goToGamePage(gameFromGamesPage);
        Game gameFromGamePage = gamePage.getGameModel();
        Assert.assertTrue(gameFromGamePage.equalsNamePriceDiscount(gameFromGamesPage));

    }
}
