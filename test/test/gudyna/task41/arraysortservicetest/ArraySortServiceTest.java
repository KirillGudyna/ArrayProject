package test.gudyna.task41.arraysortservicetest;

import com.gudyna.task41.entity.UserArray;
import com.gudyna.task41.exception.ProgramException;
import com.gudyna.task41.service.ArraySortService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ArraySortServiceTest {
    UserArray userArray;
    ArraySortService service;

    @BeforeTest
    public void setUp() {
        int[] array = new int[]{2, 5, 6, 1, 0, 16, 10, 17};
        userArray = new UserArray(array);
        service = new ArraySortService();
    }

    @Test
    public void sortBubbleTest() {
        int[] answer = new int[]{0, 1, 2, 5, 6, 10, 16, 17};
        UserArray expected = new UserArray(answer);
        try {
            service.bubbleSort(userArray);
            assertEquals(userArray, expected);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortDownTest() {
        int[] answer = new int[]{17, 16, 10, 6, 5, 2, 1, 0};
        UserArray expected = new UserArray(answer);
        try {
            service.bubbleSortDown(userArray);
            assertEquals(userArray, expected);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void sortShellTest() {
        int[] answer = new int[]{0, 1, 2, 5, 6, 10, 16, 17};
        UserArray expected = new UserArray(answer);
        try {
            service.sortShell(userArray);
            assertEquals(userArray, expected);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void sortShellDownTest() {
        int[] answer = new int[]{17, 16, 10, 6, 5, 2, 1, 0};
        UserArray expected = new UserArray(answer);
        try {
            service.sortShellDown(userArray);
            assertEquals(userArray, expected);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void sortSelectionTest() {
        int[] answer = new int[]{0, 1, 2, 5, 6, 10, 16, 17};
        UserArray expected = new UserArray(answer);
        try {
            service.sortSelection(userArray);
            assertEquals(userArray, expected);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void sortSelectionDownTest() {
        int[] answer = new int[]{17, 16, 10, 6, 5, 2, 1, 0};
        UserArray expected = new UserArray(answer);
        try {
            service.sortSelectionDown(userArray);
            assertEquals(userArray, expected);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }
}
