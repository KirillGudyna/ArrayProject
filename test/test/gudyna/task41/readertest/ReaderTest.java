package test.gudyna.task41.readertest;

import com.gudyna.task41.entity.UserArray;
import com.gudyna.task41.exception.ProgramException;
import com.gudyna.task41.reader.UserReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ReaderTest {
    UserReader userReader;
    UserArray userArray;

    @BeforeTest
    public void setUp() {
        userReader = new UserReader();
        userArray = new UserArray();
    }

    @Test
    public void fillArrayFileTest() {
        int[] array = new int[]{2, 2, 3, 4, 6555, 9, 44, 43};
        UserArray expected = new UserArray(array);
        try {
            userArray = userReader.fillArrayFile("resources\\inputArray.txt");
            assertEquals(expected, userArray);
        } catch (ProgramException e) {
            fail(e.getMessage());
        }

    }
}
