package asserts;

import model.Game;
import org.testng.Assert;
import utils.DownloadFile;

import static logger.log4j2.log;

public class Asserts {
    public static void gameEquals(Game game1, Game game2){
        try {
            Assert.assertTrue(game1.equalsNamePriceDiscount(game2),
                    "Game info doesn't match"+
                            "\n1st Game name = "+game1.getName()+" 2nd Game name = " +game2.getName()+
                            "\n1st Game discount = "+game1.getDiscount()+" 2nd Game discount = " +game2.getDiscount()+
                            "\n1st Game price = "+game1.getPrice()+" 2nd Game price = " +game2.getPrice()+"\n");
        }
        catch (Throwable e){
            log().error("equalsNamePriceDiscount is failed", e);
            Assert.fail();
        }
    }

    public static void isFileDownloaded(){
        DownloadFile downloadFile = new DownloadFile();
        try {
            Assert.assertTrue(downloadFile.isFileDownloaded(),
                    "File is not downloaded correctly");
        }
        catch (Throwable e){
            log().error("isFileDownloaded is failed", e);
            Assert.fail();
        }
    }
}
