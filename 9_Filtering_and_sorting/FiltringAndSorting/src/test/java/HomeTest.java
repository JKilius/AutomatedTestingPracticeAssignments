import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HomeTest extends BaseTest {

    HomePage homePage;

    @Test
    void selectPageSizeValue() {
        homePage = new HomePage(driver);

        homePage.clickDropdown();

        String value = "20";

        homePage.selectSizeOfPageSize(value);

        assertEquals("20", homePage.getValueOfPageSize());

    }

    @Test
    void assertIfTheListOfProductsIsSortedByDefault() {
        homePage = new HomePage(driver);

        homePage.clickDropdown();

        String value = "20";

        homePage.selectSizeOfPageSize(value);

        List<String> sortedList = homePage.getListOfAllProductNames().stream().sorted().toList();

        assertNotEquals(sortedList, homePage.getListOfAllProductNames());

    }

    @Test
    void assertIfTheListOfProductsIsSortedAfterClickingSort() {
        homePage = new HomePage(driver);

        homePage.clickDropdown();

        String value = "5";

        homePage.clickSortItems();

        List<String> sortedList = homePage.getListOfAllProductNames().stream().sorted().toList();

        assertEquals(sortedList, homePage.getListOfAllProductNames());

        // Veikia ir su vienu ir su kitu

//        List<String> sortedList = homePage.getListOfProductsFromAllPages().stream().sorted().toList();
//
//        assertEquals(sortedList, homePage.getListOfProductsFromAllPages());

    }

    @Test
    void assertIfSearchProvidesCorrectResult() {

        selectPageSizeValue();

        String searchable = "an";

        List<String> beforeFilter = homePage.getListOfAllProductNames();

        List<String> containsStringBeforeFilter = homePage.getListOfAllProductNames().stream().filter(a -> a.contains(searchable)).toList();

        homePage.enterStringInToSearchField(searchable);

        List<String> containsStringAfterFilter = homePage.getListOfAllProductNames().stream().toList();

        List<String> afterFilter = homePage.getListOfAllProductNames();

        assertNotEquals(beforeFilter, afterFilter);

        assertEquals(containsStringBeforeFilter, containsStringAfterFilter);

    }

    @Test
    void assertBothListsAreEqual() {
        homePage = new HomePage(driver);

        List<String> fullList = homePage.getListOfProductsFromAllPages();

        List<String> mainList = homePage.getListOfAllProductNames();

        assertEquals(mainList, fullList);

    }


}
