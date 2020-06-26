package test.gudyna.task42;

import com.gudyna.task42.comparator.MaxComparator;
import com.gudyna.task42.comparator.MinComparator;
import com.gudyna.task42.comparator.SumComparator;
import com.gudyna.task42.exception.ProgramException;
import com.gudyna.task42.service.JaggedArrayService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class JaggedArrayServiceTest {

    JaggedArrayService jaggedArrayService;
    int[][] actual;

    @BeforeMethod
    public void setUp() {
        jaggedArrayService = new JaggedArrayService();
        actual = new int[][]{{10, 88, 95}, {1, 99, 20}, {100, 125, 30}};
    }

    @Test
    public void sortArrayTestMin() {
        int[][] expected = new int[][]{{1, 99, 20}, {10, 88, 95}, {100, 125, 30}};
        try {
            jaggedArrayService.sortArray(actual, new MinComparator(), false);
            boolean answer = jaggedArrayService.jaggedArraysEquals(actual, expected);
            assertTrue(answer);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test
    public void sortArrayTestMinReverse() {
        int[][] expected = new int[][]{{100, 125, 30}, {10, 88, 95}, {1, 99, 20}};
        try {
            jaggedArrayService.sortArray(actual, new MinComparator(), true);
            boolean answer = jaggedArrayService.jaggedArraysEquals(actual, expected);
            assertTrue(answer);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test
    public void sortArrayTestMax() {
        int[][] expected = new int[][]{{10, 88, 95}, {1, 99, 20}, {100, 125, 30}};
        try {
            jaggedArrayService.sortArray(actual, new MaxComparator(), false);
            boolean answer = jaggedArrayService.jaggedArraysEquals(actual, expected);
            assertTrue(answer);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test
    public void sortArrayTestMaxReverse() {
        int[][] expected = new int[][]{{100, 125, 30}, {1, 99, 20}, {10, 88, 95}};
        try {
            jaggedArrayService.sortArray(actual, new MaxComparator(), true);
            boolean answer = jaggedArrayService.jaggedArraysEquals(actual, expected);
            assertTrue(answer);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test
    public void sortArrayTestSum() {
        int[][] expected = new int[][]{{1, 99, 20}, {10, 88, 95}, {100, 125, 30}};
        try {
            jaggedArrayService.sortArray(actual, new SumComparator(), false);
            boolean answer = jaggedArrayService.jaggedArraysEquals(actual, expected);
            assertTrue(answer);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test
    public void sortArrayTestSumReverse() {
        int[][] expected = new int[][]{{100, 125, 30}, {10, 88, 95}, {1, 99, 20}};
        try {
            jaggedArrayService.sortArray(actual, new SumComparator(), true);
            boolean answer = jaggedArrayService.jaggedArraysEquals(actual, expected);
            assertTrue(answer);
        } catch (ProgramException e) {
            fail();
        }
    }
}
