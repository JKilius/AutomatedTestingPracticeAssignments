import org.junit.jupiter.api.Test;

public class ClickTest extends BaseTest{

    ClickPage clickPage;

    @Test
    void clickAllSquares(){

        clickPage = new ClickPage(driver);

//        clickPage.clickAllSquares();
//
//        clickPage.submitAlert();
//
//        clickPage.clickAllSquares();
//
//        clickPage.submitAlert();


        clickPage.clickEverythingEverywhereAllAtOnce();




    }

}
