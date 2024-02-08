import lt.techin.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends BasePageTest{

    MainPage mainPage;


//@ParameterizedTest
//    @CsvFileSource(files="src/main/resources/items.csv", numLinesToSkip = 1)
//    void testAddingItemsAndCalories(String item, String calories){
//    mainPage = new MainPage(driver);
//
//
//
//    mainPage.enterTextItem(item);
//    mainPage.enterNumberOfCalories(calories);
//    mainPage.clickAddMeal();
//
//
//
//
//}

    @Test
    void testAddItems(){
        mainPage = new MainPage(driver);

        mainPage.enterTextItem("Apple");
        mainPage.enterNumberOfCalories("95");
        mainPage.clickAddMeal();
        mainPage.enterTextItem("Banana");
        mainPage.enterNumberOfCalories("105");
        mainPage.clickAddMeal();
        mainPage.enterTextItem("Carrot");
        mainPage.enterNumberOfCalories("25");
        mainPage.clickAddMeal();
        mainPage.enterTextItem("Egg");
        mainPage.enterNumberOfCalories("70");
        mainPage.clickAddMeal();

        assertTrue(mainPage.isItemInTheList("Apple"));

    }

    @Test
    void assertIfCountOfCaloriesIsCorrect(){
        mainPage = new MainPage(driver);

        mainPage.addAListOfItemsAndCalories();

        assertEquals(mainPage.getAllCalories(), mainPage.countAllCalories());

        System.out.println(mainPage.getAllItemNames());
    }

    @Test
    void assertIfButtonClearAllWorks(){
        mainPage = new MainPage(driver);

        mainPage.addAListOfItemsAndCalories();

        mainPage.clickClearAll();

        assertTrue(mainPage.getAllItems().isEmpty());
    }

    @Test
    void assertIfEditItemFunctionWorks(){
        mainPage = new MainPage(driver);

        mainPage.addAListOfItemsAndCalories();

        mainPage.selectItemToEditByName("Egg");
        mainPage.clearInputItem();

        mainPage.enterTextItem("Kebabas");
        mainPage.enterNumberOfCalories("10000");
        mainPage.clickButtonUpdateMeal();

        assertTrue(mainPage.isItemInTheList("Kebabas"));
        assertEquals(mainPage.getAllCalories(), mainPage.countAllCalories());

    }

    @Test
    void assertIfDeleteItemFunctionWorks(){
        mainPage = new MainPage(driver);

        mainPage.addAListOfItemsAndCalories();

        mainPage.selectItemToEditByName("Egg");

        mainPage.clickButtonDeleteMeal();

        assertFalse(mainPage.isItemInTheList("Egg"));
        assertEquals(mainPage.getAllCalories(), mainPage.countAllCalories());

    }

    @Test
    void assertIfGoBackFunctionWorks(){
        mainPage = new MainPage(driver);

        mainPage.addAListOfItemsAndCalories();

        mainPage.selectItemToEditByName("Egg");

        mainPage.clearInputItem();

        mainPage.enterTextItem("Kebabas");
        mainPage.enterNumberOfCalories("10000");
        mainPage.clickButtonBack();

        assertTrue(mainPage.isItemInTheList("Egg"));

        assertEquals(mainPage.getAllCalories(), mainPage.countAllCalories());
    }




}
