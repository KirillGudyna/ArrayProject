package test.gudyna.task41.arrayservicetest;

import com.gudyna.task41.entity.UserArray;
import com.gudyna.task41.exception.ProgramException;
import com.gudyna.task41.service.ArraySearchService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ArrayServiceTest {
    UserArray userArray;
    ArraySearchService service;

    @BeforeTest
    public void setUp() {
        int[] array = new int[]{0, 2, 3, 5, 4, 9, 12, 7, 10, 18, 13, 1836311903, 123, 234, 890, 222, 111, 333, 567};
        userArray = new UserArray(array);
        service = new ArraySearchService();
    }

    @Test
    public void primeNumberTest() {

        int[] arrayInt = new int[]{2, 3, 5, 7, 13};
        UserArray expected = new UserArray(arrayInt);
        UserArray actual;
        try {
            actual = service.findPrimeNumbers(userArray);
            assertEquals(expected, actual);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void fibonacciNumberTest() {
        int[] arrayInt = new int[]{0, 2, 3, 5, 13, 1836311903};
        UserArray expected = new UserArray(arrayInt);
        UserArray actual;
        try {
            actual = service.findFibonacciNumbers(userArray);
            assertEquals(expected, actual);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void uniqueThreeDigitNumberTest() {
        int[] arrayInt = new int[]{123, 234, 890, 567};
        UserArray expected = new UserArray(arrayInt);
        UserArray actual;
        try {
            actual = service.findUniqueThreeDigitNumbers(userArray);
            assertEquals(expected, actual);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void binarySearchTest() {
        int expected = 6;
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 12};
        userArray.setArrayNumber(array);
        try {
            int actual = service.binarySearch(userArray, 12);
            assertEquals(expected, actual);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }
    }
}
