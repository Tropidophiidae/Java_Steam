package tests;

import bars.StoreBar;
import global.genre.Action;
import global.option.TopSelling;
import model.Game;
import org.testng.annotations.Test;
import pages.GamePage;
import pages.GamesPage;

import static asserts.Asserts.gameEquals;
import static logger.log4j2.log;

public class GameWithMaxDiscount extends BaseTest {

    @Test
    public void GameWithMaxDiscountTest(){
        log().info("Test Case --- " + this.getClass().getSimpleName());
        StoreBar storeBar = new StoreBar();
        GamesPage gamesPage = new GamesPage();
        GamePage gamePage = new GamePage();

        log().info("Step 1 --- Go to Steam website");
        goToStartPage();
        log().info("Step 2 --- Select Action genre in Games dropdown");
        storeBar.goToGenre(new Action());
        log().info("Step 3 --- Go to Top Sellers tab");
        gamesPage.selectOption(new TopSelling());
        log().info("Step 4 --- Find a game with the highest discount");
        log().info("Step 5 --- Remember the game Name, Price and Discount");
        Game gameFromGamesPage = gamesPage.getGameWithMaxDiscount();
        log().info("Step 6 --- Go to the game page");
        gamesPage.goToGamePage(gameFromGamesPage);
        log().info("Step 7 --- Check Name, Price and Discount from the game page the same as in Step 5.");
        Game gameFromGamePage = gamePage.getGameModel();
        gameEquals(gameFromGamePage, gameFromGamesPage);
    }
}
