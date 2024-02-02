package ToDoListTest;

import ToDoListPage.ToDoListBase;
import ToDoListPage.ToDoListMain;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends BaseTest {

    ToDoListBase toDoListBase;
    ToDoListMain toDoListMain;


    @Test
    void inputNewInput() {
        toDoListBase = new ToDoListBase(driver);
        toDoListMain = new ToDoListMain(driver);
        String input = "This is a new entry";
        int countInit = toDoListMain.countEntries();
        toDoListMain.enterNewInput(input);
        String toCheck = toDoListMain.getLastEntryText();
        assertEquals(input, toCheck);
        assertEquals(countInit+1, toDoListMain.countEntries());

    }

    @Test
    void checkEntryAsDone() {
        toDoListBase = new ToDoListBase(driver);
        toDoListMain = new ToDoListMain(driver);
        Actions actions = new Actions(driver);

        inputNewInput();
        String classBeforeComplete = toDoListMain.getEntryClass();
        System.out.println(classBeforeComplete);

        toDoListMain.clickEntry();

        assertTrue(toDoListMain.getEntryClass().contains("completed"));

        assertFalse(toDoListMain.checkAllEntryStatusExceptForLast());

    }

    @Test
    void deleteSelectedElementFromList(){
        toDoListBase = new ToDoListBase(driver);
        toDoListMain = new ToDoListMain(driver);
        Actions actions = new Actions(driver);

        toDoListMain.deletion("Practice magic");


    }


}
